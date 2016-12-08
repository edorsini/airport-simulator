/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.airport;

public class RunwayAvailableState implements RunwayState {
	Runway runway;

	public RunwayAvailableState(Runway runway) {
		this.runway = runway;
	}
	
	@Override
	public void setBusyState() {
		runway.setState(runway.getBusyState());
	}

	@Override
	public void setAvailableState() {
		System.out.println("This state cannot set itself to available");
	}
	
	// Starts a landing
	public void startLanding() {
		if (runway.getTimeLeft() > 0) {
			throw new IllegalStateException("Landing strip is already busy!");
		}
		runway.setTimeLeft(runway.getMinutesToLand());
	}
	
	// Starts a take-off
	public void startTakeoff() {
		if (runway.getTimeLeft() > 0) {
			throw new IllegalStateException("Landing strip is already busy!");
		}
		runway.setTimeLeft(runway.getMinutesToTakeoff());
	}

}
