/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.airport;

public class RedBrand extends FuselageDecorator {
	Fuselage fuselage;
	
	public RedBrand(Fuselage fuselage) {
		this.fuselage = fuselage;
	}

	public RedBrand(Aircraft createAircraft) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		return " Red branded...";
	}

	@Override
	public Aircraft createAircraft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

}
