/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.random;

public class ProbabilityGenerator {
	private double probability;
	
	// Constructor
	public ProbabilityGenerator(double p) {
		if ((p < 0) || (1 < p)) {
			throw new IllegalArgumentException("Illegal probability: " + p);
		}
		probability = p;
	}
	
	// Returns either true or false a certain % of the time
	public boolean query() {
		return (Math.random() < probability);
	}
}
