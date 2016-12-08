/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.airport;

public abstract class Aircraft implements Airline {
	protected int id;
	protected int amountOfFuel;
	protected int timeIn;
	protected int timeOut;
	
	/*
	// Constructor
	public Aircraft( int id, int timeIn, int amountOfFuel) {
		this.id = id;
		this.timeIn = timeIn;
		this.amountOfFuel = amountOfFuel;
	}
	*/
	
	// Sets id of the plane
	public void setId(int id) {
		this.id = id;
	}
	
	// Gets id of the plane
	public int getId() {
		return this.id;
	}
	
	// Gets the amount of fuel that the plane can use to circle around while waiting to land
	public int getAmountOfFuel() {
		return amountOfFuel;
	}
	
	// Set the amount of fuel
	public void setAmountOfFuel(int amountOfFuel) {
		this.amountOfFuel = amountOfFuel;
	}
	
	// Gets the time (current minute) the plane has been placed in the queue
	public int getTimeIn() {
		return timeIn;
	}
	
	// Sets the time the plane has been placed in the queue
	public void setTimeIn(int timeIn) {
		this.timeIn = timeIn;
	}
	
	// Gets the time (current minute) the plane was popped out of the queue
	public int getTimeOut() {
		return timeOut;
	}
	
	// Sets the time the plane was popped out of the queue
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	
	public abstract Aircraft createAircraft();
	
	public abstract void fly();
}
