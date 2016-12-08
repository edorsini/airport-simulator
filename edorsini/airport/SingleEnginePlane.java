/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.airport;

public class SingleEnginePlane extends Aircraft {
	int minNumberOfEngines = 1;
	int maxNumberOfEngines = 1;

	public SingleEnginePlane() {
		//super();
	}
	
	public Aircraft createAircraft() {
		return new SingleEnginePlane();
	}
	
	public void fly() {
		System.out.println("Flying with only one engine!");
	}

}
