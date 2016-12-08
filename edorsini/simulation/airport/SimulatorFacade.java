/**
 * Ed Orsini
 * Airport Simulation
 */
package edorsini.simulation.airport;

public class SimulatorFacade {
	/*
 	(1) The amount of time needed for one plane to land
 	(2) The amount of time needed for one plane to take off
 	(3) The average amount of time between arrival of planes to the landing queue
 	(4) The average amount of time between arrival of planes to the take-off queue
 	(5) The maximum amount of time that a plane can stay in the landing queue without running our of fuel and crashing
 	(6) The total length of time to be simulated
 	*/
	int planeToLand;
	int planeToTakeoff;
	double averageTimeBetweenArrivals;
	double averageTimeBetweenDepartures;
	int gasTankCapacity;
	int totalTimeSimulated;
	
	Data data;
	Display display;
	Simulator simulator;
	
	public SimulatorFacade(int planeToLand, int planeToTakeoff, double averageTimeBetweenArrivals, double averageTimeBetweenDepartures, int gasTankCapacity, int totalTimeSimulated) {
		this.planeToLand = planeToLand;
		this.planeToTakeoff = planeToTakeoff;
		this.averageTimeBetweenArrivals = averageTimeBetweenArrivals;
		this.averageTimeBetweenDepartures = averageTimeBetweenDepartures;
		this.gasTankCapacity = gasTankCapacity;
		this.totalTimeSimulated = totalTimeSimulated;
		
		// Handle all the complex functionality within these objects which is abstracted from the client.
		//data = new Data(planeToLand, planeToTakeoff, averageTimeBetweenArrivals, averageTimeBetweenDepartures, gasTankCapacity, totalTimeSimulated);
		//display = Display.getInstance(data);
		simulator = new Simulator(planeToLand, planeToTakeoff, averageTimeBetweenArrivals, averageTimeBetweenDepartures, gasTankCapacity, totalTimeSimulated);
	}
	
	// Allow the client a clean interface of starting the simulation and displaying the simulation data:
	
	public void startSimulation() {
		simulator.start();
	}
		

	
}
