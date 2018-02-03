package week04;

public class GasStation {

	//variables
	private String name;
	private Location location;
	
	/**
	 * Constructor
	 * @param name name of gas station
	 * @param location location of gas station
	 */
	public GasStation(String name, Location location) {
		this.name = name;
		this.location = location;
	}

	/**
	 * return the name of the gas station
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the gas station
	 * @param name of gas station
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the location of a gas station
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets the location of a gas station
	 * @param location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	/**
	 * Default toString
	 */
	public String toString()
	{
		return this.name + " at " + location;
	}

	
}
