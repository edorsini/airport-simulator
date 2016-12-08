/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.airport;

import java.util.ArrayList;

public abstract class SubjectBase {
    private ArrayList<ObserverBase> subscribers = new ArrayList<ObserverBase>();

    public void subscribe(ObserverBase o) {
        // add subscriber to the subscriber Arraylist
    	subscribers.add(o);
    }

    public void unsubscribe(ObserverBase o) {
        // remove subscriber to the subscriber Arraylist
    	subscribers.remove(o);
    }

    public void notifyOthers() {
        // call update method on each subscriber when the data changes
    	for (ObserverBase o : subscribers) {
            o.updateSelf();
         }
    }

}
