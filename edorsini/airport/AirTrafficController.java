/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.airport;

public class AirTrafficController extends ObserverBase {
	private Weather weather;
	private String name;
	private String state;
	
	public AirTrafficController(String state, String name, Weather weather) {
		this.weather = weather;
		this.name = name;
		this.state = state;
	}

	@Override
	public void updateSelf() {
		state = weather.getState();	
	}
	
	public String getState() {
		return this.state;
	}

	
}


