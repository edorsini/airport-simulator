/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.airport;

public class Runway {
	private int minutesToLand;
	private int minutesToTakeoff;
	private int timeLeft;
	
	// Runway states for State Design Pattern
	RunwayState busy;
	RunwayState available;
	
	RunwayState state = available;
	
	// Constructor
	public Runway(int mLand, int mTakeoff) {
		this.minutesToLand = mLand;
		this.minutesToTakeoff = mTakeoff;
		this.timeLeft = 0;
		
		this.busy = new RunwayBusyState(this);
		this.available = new RunwayAvailableState(this);
	}
	
	public void setState(RunwayState state) {
		this.state = state;
	}
	
	public RunwayState getState() {
		return this.state;
	}
	
	public RunwayState getBusyState() {
		return this.busy;
	}
	
	public RunwayState getAvailableState() {
		return this.available;
	}
	
	public int getTimeLeft() {
		return this.timeLeft;
	}
	
	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}
	
	public int getMinutesToLand() {
		return this.minutesToLand;
	}
	
	public int getMinutesToTakeoff() {
		return this.minutesToTakeoff;
	}
	
	// Returns whether or not the run-way is busy at a given minute
	public boolean isBeingUsed() {
		boolean isBeingUsed = timeLeft > 0;
		
		if (isBeingUsed) {
			this.setState(getBusyState());
		} else {
			this.setState(getAvailableState());
		}
		return isBeingUsed;
	}
	
	// Reduces the time the run-way is busy by a minute
	public void reduceRemainingTime() {
		if (timeLeft > 0) {
			timeLeft--;
		}
	}
	
	/*
	// Before the State Design Pattern
	// Starts a landing
	public void startLanding() {
		if (timeLeft > 0) {
			throw new IllegalStateException("Landing strip is already busy!");
		}
		timeLeft = minutesToLand;
	}
	
	// Starts a take-off
	public void startTakeoff() {
		if (timeLeft > 0) {
			throw new IllegalStateException("Landing strip is already busy!");
		}
		timeLeft = minutesToTakeoff;
	}
	*/

}
