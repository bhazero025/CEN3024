package week04;

public class InvalidLocationException extends Exception 
{
	private Location location;
	public InvalidLocationException()
	{
		super();
	}
	
	public InvalidLocationException(Location l) 
	{
		super("Invalid Location " + l.getAvenue() + ", " + l.getStreet());
		location = l;
	}
	
	public Location getInvalidLocation()
	{
		return location;
	}
}
