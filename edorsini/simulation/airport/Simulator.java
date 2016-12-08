/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.simulation.airport;

import edorsini.random.ProbabilityGenerator;
import edorsini.simulation.airport.Display;
import edorsini.airport.SingleEnginePlane;
import edorsini.airport.Weather;
import edorsini.queues.AircraftArrayQueue;
import edorsini.airport.AirTrafficController;
import edorsini.airport.Aircraft;
import edorsini.airport.Airline;
import edorsini.airport.BlueBrand;
import edorsini.airport.FuselageDecorator;
import edorsini.airport.MultiEnginePlane;
import edorsini.airport.RedBrand;
import edorsini.airport.Runway;

public class Simulator {
	
	int counterId = 0; // Variable for assigning IDs to planes as they are created
	Display display; // Responsible for displaying messages to the console
	Data data; // Responsible for retaining the data 
	
	AircraftArrayQueue landingQueue, takeoffQueue;
	Runway runway;
	ProbabilityGenerator arrival, departure, typeOfPlane;
	
	
	// Constructor
	public Simulator(int timeLand, int timeTakeoff, double timeAvgArrival, double timeAvgDeparture, int timeMaxInAir, int timeTotal) {
		this.data = new Data(timeLand, timeTakeoff, timeAvgArrival, timeAvgDeparture, timeMaxInAir, timeTotal);
		this.display = Display.getInstance(this.data); // Singleton Design Pattern
		this.landingQueue = new AircraftArrayQueue(100);
		this.takeoffQueue = new AircraftArrayQueue(100);
	}
	
	// Start the simulation
	public void start() {
		display.startMessage();
		airportInit();
		airportRun();
		airportCrunchData();
		display.simulationSummary();
		display.endMessage();
	}
	
	// Generates and returns a new ID to give a newly created plane
	public int getNextId() {
		return ++counterId;
	}
	
	public boolean isInputValid() {
		// Check conditions
		if (data.timeLand <= 0 || data.timeTakeoff <= 0 || data.timeAvgArrival < 0 || data.timeAvgArrival > 1 || data.timeAvgDeparture < 0 || data.timeAvgDeparture > 1 || data.timeTotal < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void airportInit() {
		
		// Set up the Air Traffic Control Tower and weather objects
		Weather currentWeather = new Weather();
		AirTrafficController tower = new AirTrafficController(currentWeather.getState(), "Main Tower", currentWeather);
		currentWeather.subscribe(tower);
		
		// change the weather..
		currentWeather.setState("raining...");
		
		System.out.println("The control tower reports the weather is: " + tower.getState());
		System.out.println("The weather object reports the weather is: " + currentWeather.getState());
		
		// Set up probabilities
		arrival = new ProbabilityGenerator(data.timeAvgArrival);
		departure = new ProbabilityGenerator(data.timeAvgDeparture);
		
		// Create new landing strip object to perform the landings and take-offs
		runway = new Runway(data.timeLand, data.timeTakeoff);
		
		// Display parameters used to the user
		display.simulationParameters();
		
		if (!isInputValid()) {
			throw new IllegalArgumentException("Input values are not acceptable.");
		}
		

	}
	
	public Aircraft randomlyGenerateAircraft(int id, int currentMinute, int amountOfFuel) {
		ProbabilityGenerator typeOfPlaneProbability = new ProbabilityGenerator(.5);
		Aircraft newPlane;
		Aircraft aircraftFactory;
		
		if (typeOfPlaneProbability.query()) {
			aircraftFactory = new MultiEnginePlane();
			newPlane = new BlueBrand(aircraftFactory.createAircraft());
		} else {
			aircraftFactory = new SingleEnginePlane();
			newPlane = new RedBrand(aircraftFactory.createAircraft());
		}
		
		
		newPlane.setId(id);
		newPlane.setAmountOfFuel(amountOfFuel);
		newPlane.setTimeIn(currentMinute);
		System.out.println("New plane created is a: " + ((FuselageDecorator) newPlane).getDescription());
		return newPlane;
	}
	
	public void airportRun() {
		int currentMinute;
		Aircraft temp_plane;
		
		for (currentMinute = 0; currentMinute < data.timeTotal; currentMinute++) {

			// Check whether a new plane is wants to land
			if (arrival.query()) {
				landingQueue.add(randomlyGenerateAircraft(getNextId(), currentMinute, data.timeMaxInAir));
			}
			// Check whether a new plane is wants to take-off
			if (departure.query()) {
				takeoffQueue.add(randomlyGenerateAircraft(getNextId(), currentMinute, data.timeMaxInAir));;
			}
			
			System.out.println("\n---------(start of iteration - current minute: " + currentMinute + ")");
			System.out.println("ARRIVALS: " + landingQueue);
			System.out.println("DEPARTURES: " + takeoffQueue + "\n");
			
			// Check if we can start using the runway
			if ((runway.isBeingUsed() == false)) {
				display.freeRunway();
				if ((landingQueue.isEmpty() == false)) {
					display.waitingToLand();
					//runway.startLanding();
					runway.getState().startLanding();
					temp_plane = landingQueue.remove();
					temp_plane.setTimeOut(currentMinute);
					data.planesLanded.addPlane(temp_plane);
				} else if((takeoffQueue.isEmpty() == false)) {
					display.waitingToTakeoff();
					//runway.startTakeoff();
					runway.getState().startTakeoff();
					temp_plane = takeoffQueue.remove();
					temp_plane.setTimeOut(currentMinute);
					data.planesTakenoff.addPlane(temp_plane);
				}
			} else {
				display.busyRunway();
			}
			runway.reduceRemainingTime();
			System.out.println("\nARRIVALS (end of iteration): " + landingQueue);
			System.out.println("DEPARTURES (end of iteration): " + takeoffQueue + "\n");
		}
	}
	
	public void determineHowManyPlanesCrashed() {
		// Generate the total number of crashed planes
		// total time of simulation - time the plane checked into queue = how much time the plane has been flying around
		// how much time the plane has been flying around should be less than the allowed time maximum; else the plane has crashed.
		for (int i=0; i< landingQueue.currentSize(); i++) {
			if ((data.timeTotal - landingQueue.getQueue()[i].getTimeIn()) > data.timeMaxInAir) {
				data.incrementTotalPlanesCrashed();
			}
		}
	}
	
	public void airportCrunchData() {
		// Planes landed
		data.setTotalPlanesLanded(data.planesLanded.getCount());
		data.setPlanesLandedAverageTime(data.planesLanded.getAverageTimeInQueue());
		
		// Planes taken-off
		data.setTotalPlanesTakenOff(data.planesTakenoff.getCount());
		data.setPlanesTakenOffAverageTime(data.planesTakenoff.getAverageTimeInQueue());
		
		// Planes waiting to land
		data.setPlaneswaitingToLand(landingQueue.currentSize());
	
		// Planes crashed
		determineHowManyPlanesCrashed();
	}
	
} 

