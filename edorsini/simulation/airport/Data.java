/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.simulation.airport;

import edorsini.queues.AircraftQueueSummary;

public class Data {
	// Simulator parameters:
	int timeLand, timeTakeoff, timeMaxInAir, timeTotal;
	double timeAvgArrival, timeAvgDeparture;
	
	AircraftQueueSummary planesLanded, planesTakenoff;
	int totalPlanesLanded;
	double planesLandedAverageTime;
	int totalPlanesTakenOff;
	double planesTakenOffAverageTime;
	int planesWaitingToLand;
	int totalPlanesCrashed;
	
	// Constructor
	public Data(int timeLand, int timeTakeoff, double timeAvgArrival, double timeAvgDeparture, int timeMaxInAir, int timeTotal) {
		this.timeLand = timeLand;
		this.timeTakeoff = timeTakeoff;
		this.timeAvgArrival = timeAvgArrival;
		this.timeAvgDeparture = timeAvgDeparture;
		this.timeMaxInAir = timeMaxInAir;
		this.timeTotal = timeTotal;
		this.planesLanded = new AircraftQueueSummary();
		this.planesTakenoff = new AircraftQueueSummary();
	}
	
	public void setTotalPlanesLanded(int number) {
		this.totalPlanesLanded = number;
	}

	public int getTotalPlanesLanded() {
		return this.totalPlanesLanded;
	}

	public void setPlanesLandedAverageTime(double number) {
		this.planesLandedAverageTime = number;
	}

	public double getPlanesLandedAverageTime() {
		return this.planesLandedAverageTime;
	}
	
	
	public void setTotalPlanesTakenOff(int number) {
		this.totalPlanesTakenOff = number;
	}

	public int getTotalPlanesTakenOff() {
		return this.totalPlanesTakenOff;
	}

	public void setPlanesTakenOffAverageTime(double number) {
		this.planesTakenOffAverageTime = number;
	}

	public double getPlanesTakenOffAverageTime() {
		return this.planesTakenOffAverageTime;
	}
	
	public void setPlaneswaitingToLand(int number) {
		this.planesWaitingToLand = number;
	}

	public int getPlaneswaitingToLand() {
		return this.planesWaitingToLand;
	}
	
	public void incrementTotalPlanesCrashed() {
		this.totalPlanesCrashed++;
	}

	public int getTotalPlanesCrashed() {
		return this.totalPlanesCrashed;
	}
}
