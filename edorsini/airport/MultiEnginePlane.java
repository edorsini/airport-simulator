/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.airport;

public class MultiEnginePlane extends Aircraft {
	int minNumberOfEngines = 2;
	int maxNumberOfEngines = 0;
	
	public MultiEnginePlane() {
		//super();
	}

	@Override
	public Aircraft createAircraft() {
		return new MultiEnginePlane();
	}
	
	public void fly() {
		System.out.println("Flying with more than one engine!");
	}

}
