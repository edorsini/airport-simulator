/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.airport;

public abstract class FuselageDecorator extends Aircraft {

	Fuselage fuselage;
	
	public FuselageDecorator() {
		
	}
	
	public FuselageDecorator(Fuselage fuselage) {
		this.fuselage = fuselage;
	}
	
	public abstract String getDescription(); // {
		//return fuselage.getDescription();
	//}

}
