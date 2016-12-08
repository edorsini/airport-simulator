/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.airport;

public class RunwayBusyState implements RunwayState {
	Runway runway;

	public RunwayBusyState(Runway runway) {
		this.runway = runway;
	}
	
	@Override
	public void setBusyState() {
		System.out.println("This state cannot set itself to busy...");
	}

	@Override
	public void setAvailableState() {
		runway.setState(runway.getAvailableState());		
	}

	@Override
	public void startLanding() {
		System.out.println("This state cannot start landing...");
		
	}

	@Override
	public void startTakeoff() {
		System.out.println("This state cannot start takeoff...");		
	}

}
