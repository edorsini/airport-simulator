/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.queues;
import java.util.NoSuchElementException;
import edorsini.airport.*;

public class AircraftArrayQueue implements AircraftQueueInterface {
	private Aircraft[] queue;
	private int currentSize;
	private int currentMax;
	private int front;
	private int rear;
	
	// Constructor
	public AircraftArrayQueue(int currentMax) {
		this.queue = new Aircraft[currentMax];
		this.currentSize = 0;
		this.currentMax = currentMax;
		
		for (int i=0; i < currentMax; i++) {
			queue[i] = new SingleEnginePlane();
			queue[i].setId(0);
			queue[i].setAmountOfFuel(0);
			queue[i].setTimeIn(0);
		}
	}
	
	// Gets a copy of the queue
	public Aircraft[] getQueue() {
		Aircraft[] result = new Aircraft[currentSize];
		System.arraycopy(queue,  0,  result, 0, currentSize);
		return result;
	}
	
	// Adds a plane to the queue
	public void add(Aircraft newPlane) {
		if (currentMax == queue.length) {
			// double the capacity
			ensureCapacity(currentSize *2 +1);
		}
		if (currentSize == 0) {
			front = 0;
			rear = 0;
		} else {
			rear = nextIndex(rear);
		}
		
		queue[rear] = newPlane;
		currentSize++;
	}
	
	// Determine if the queue is empty
	public boolean isEmpty() {
		if (currentSize == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// Removes a plane from the queue
	public Aircraft remove() {
		Aircraft result;
		if (currentSize == 0) {
			throw new NoSuchElementException("Queue underflow");
		}
		result = queue[front];
		currentSize--;
		return result;
	}
	
	// Determine if the next available slot in the array is the end of the array
	public int nextIndex(int i) {
		if (++i == queue.length) {
			return 0;
		} else {
			return i;
		}
	}
	
	// Gets the current size of the queue
	public int currentSize() {
		return this.currentSize;
	}
	
	// Gets the max size of the queue
	public int maxSize() {
		return this.currentMax;
	}
	
	// Returns String representation of queue
	public String toString() {
		if (this.currentSize == 0) {
			return "empty queue";
		} 
		String result = "FRONT <-- ";
		for (int i=0; i < this.currentSize; i++) {
			result = result + queue[i].getId() + " <--";
		}
		result = result + "REAR";
		return result;
	}
	
	// Manages the size of the queue by doubling the size of the queue if needed
	public void ensureCapacity(int minimumCapacity) {
		Aircraft[] biggerArray;
		int n1, n2;
		
		if (queue.length >= minimumCapacity) {
			// No change needed
			return;
		} else if (currentSize == 0) {
			// Just increase the size of the array since the queue is empty
			queue = new Aircraft[minimumCapacity];
		} else if (front <= rear) {
			// Create larger array and copy queue[front] ... queue[rear] into int
			biggerArray = new Aircraft[minimumCapacity];
			System.arraycopy(queue, front, biggerArray, front, currentSize);
			queue = biggerArray;
		} else {
			// Special case!
			biggerArray = new Aircraft[minimumCapacity];
			n1 = queue.length - front;
			n2 = rear + 1;
			System.arraycopy(queue, front,biggerArray, 0, n1);
			System.arraycopy(queue, 0, biggerArray, n1, n2);
			front = 0;
			rear = currentSize -1;
			queue = biggerArray;
		}
	}

}
