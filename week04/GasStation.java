package week04;

public class GasStation {

	private String name;
	private Location location;
	
	public GasStation(String name, Location location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String toString()
	{
		return this.name;
	}

	
}
