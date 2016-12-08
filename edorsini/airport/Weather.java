/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.airport;

public class Weather extends SubjectBase {
	private String state;
	
	public Weather() {
		this.state = "Unkown";
	}

    public String getState() {
        return state;
    }
 
    public void setState(String state) {
        this.state = state;
        notifyOthers();
    }
    

}
