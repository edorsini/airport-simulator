/**
 * Ed Orsini
 * Airport Simulation
 */

import edorsini.simulation.airport.Simulator;
import edorsini.simulation.airport.SimulatorFacade;

public class Main {

	// Main entry into the program
	public static void main(String[] args) {
		
		/* Airport simulation method parameters to pass in:
		 	(1) The amount of time needed for one plane to land
		 	(2) The amount of time needed for one plane to take off
		 	(3) The average amount of time between arrival of planes to the landing queue
		 	(4) The average amount of time between arrival of planes to the take-off queue
		 	(5) The maximum amount of time that a plane can stay in the landing queue without running our of fuel and crashing
		 	(6) The total length of time to be simulated
		*/
		
		// NOT using the facade
		/*
		Simulator simulator = new Simulator(5,7,.30,.10,10,30);
		simulator.start();
		*/
		
		// Using the facade
		SimulatorFacade simulatorFacade = new SimulatorFacade(5,7,.30,.10,10,30);
		simulatorFacade.startSimulation();
		
		//simulatorFacade.displaySimulationData();
		
		
	}
	
}