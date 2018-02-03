package week04;

public class GasStation {

	//variables
	private String name;
	private Location location;
	
	//constructor
	public GasStation(String name, Location location) {
		this.name = name;
		this.location = location;
	}

	//returns name of the gas station
	public String getName() {
		return name;
	}

	//sets name of the gas station
	public void setName(String name) {
		this.name = name;
	}

	//returns location of gas station
	public Location getLocation() {
		return location;
	}

	//sets location of the gas station
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String toString()
	{
		return this.name;
	}

	
}
