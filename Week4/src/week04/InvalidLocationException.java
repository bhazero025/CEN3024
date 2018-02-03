package week04;

public class InvalidLocationException extends Exception 
{
	private Location location;
	/**
	 * Default constructor
	 */
	public InvalidLocationException()
	{
		super();
	}
	
	/**
	 * Handles the location exception
	 * @param location bad location
	 */
	public InvalidLocationException(Location location) 
	{
		super("Invalid Location " + location.getAvenue() + ", " + location.getStreet());
		this.location = location;
	}
	
	/**
	 * Gets invalid location
	 * @return invalid location
	 */
	public Location getInvalidLocation()
	{
		return location;
	}
}
