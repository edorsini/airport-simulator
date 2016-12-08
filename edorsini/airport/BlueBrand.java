/**
 * Ed Orsini
 * Airport Simulation
 */

package edorsini.airport;

public class BlueBrand extends FuselageDecorator {
	
	public BlueBrand(Fuselage fuselage) {
		super(fuselage);
	}

	public BlueBrand(Aircraft createAircraft) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		return " Blue branded...";
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
