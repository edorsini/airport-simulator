/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.airport;

public interface RunwayState {
	
	public void setBusyState();
	public void setAvailableState();
	public void startLanding();
	public void startTakeoff();
}
