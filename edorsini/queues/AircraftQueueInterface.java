/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.queues;

import edorsini.airport.Aircraft;

public interface AircraftQueueInterface {
	public void add(Aircraft item);
	public boolean isEmpty();
	public Aircraft remove();
	public int currentSize();
	public int maxSize();
}
