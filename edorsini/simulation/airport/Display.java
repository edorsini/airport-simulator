/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.simulation.airport;

public class Display {
	Data data;
	
	// Singleton Design Pattern
	private static Display instance = null;
	
	private Display(Data data) {
		this.data = data;
	}
	
	public static Display getInstance(Data data) {
		if (instance == null) {
			instance = new Display(data);
		}
		return instance;
	}
	
	public void startMessage() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");	
		System.out.println("+          Start of the simulation          +");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");	
	}
	
	public void endMessage() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+          End of the simulation          +");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
	}
	
	public void simulationParameters() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+          Simulation Parameters                                        +");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+  Minutes for a plane to land:                                 " + this.data.timeLand);
		System.out.println("+  Minutes for a plane to take-off:                             " + this.data.timeTakeoff);
		System.out.println("+  Probability that a planes needs to land any given minute:    " + this.data.timeAvgArrival*100 + "%");
		System.out.println("+  Probability that a plane needs to take-off any given minute: " + this.data.timeAvgDeparture*100 + "%");
		System.out.println("+  Maximum number of minutes a plane can stay in the air:       " + this.data.timeMaxInAir);
		System.out.println("+  Total minutes for simulation:                                " + this.data.timeTotal);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	public void simulationSummary() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+           Simulation Results                                          +");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+  Total planes landed: " + data.getTotalPlanesLanded());
		System.out.println("+  Average time in the landing queue: " + data.getPlanesLandedAverageTime() + " minutes.");		
		System.out.println("+  Total planes planes that took off: " + data.getTotalPlanesTakenOff());
		System.out.println("+  Average time in take-off queue: " + data.getPlanesTakenOffAverageTime() + " minutes.");
		System.out.println("+  Waiting to land: " + data.getPlaneswaitingToLand());
		System.out.println("+  Crashed: " + data.getTotalPlanesCrashed());
	}
	
	public void freeRunway() {
		System.out.println("...runway is free...");
	}
	
	public void busyRunway() {
		System.out.println("...runway is busy...");
	}

	public void waitingToLand() {
		System.out.print("...planes are waiting to land...");
	}
	
	public void waitingToTakeoff() {
		System.out.print("...planes are waiting to take off...");
	}
	
}
