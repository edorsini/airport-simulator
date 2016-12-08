/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.queues;

import edorsini.airport.Aircraft;

public class AircraftQueueSummary {
	private int count;
	private double sumTimeInQueue;
	
	// Constructor
	public AircraftQueueSummary() {
		count = 0;
		sumTimeInQueue = 0;
	}
	
	// Adds a plane to the count and keeps a sum of all the times the planes checked into the queue.
	public void addPlane(Aircraft temp_plane) {
		if (count == Integer.MAX_VALUE) {
			throw new IllegalStateException("Too many planes!");
		}
		count++;
		sumTimeInQueue += temp_plane.getTimeOut() - temp_plane.getTimeIn();
	}
	
	// Returns a count of all the planes added
	public int getCount() {
		return this.count;
	}
	
	// Returns the average of all the planes landed
	public double getAverageTimeInQueue() {
		if (count == 0) {
			return Double.NaN;
		} else {
			return sumTimeInQueue/count;
		}
	}

}
