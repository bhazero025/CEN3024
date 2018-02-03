package week04;

public class Location {

	private int street, ave;
	
	/**
	 * Default Contructor
	 */
	public Location()
	{
		this.street = 0;
		this.ave = 0;
	}
	
	/**
	 * Contructor that takes street and ave
	 * @param street street for the location 
	 * @param ave avenue for the location
	 */
	public Location(int street, int ave) 
	{
		this.street = street;
		this.ave = ave;
	}

	/**
	 * Gets the street
	 * @return street name
	 */
	public int getStreet() {
		return street;
	}

	/**
	 * Sets the street
	 * @param street 
	 */
	public void setStreet(int street) {
		this.street = street;
	}

	/**
	 * Retuns avenue
	 * @return avenue
	 */
	public int getAvenue() {
		return ave;
	}

	/**
	 * Sets the avenue
	 * @param ave avenue to set
	 */
	public void setAve(int ave) {
		this.ave = ave;
	}

	/**
	 * Default toString
	 */
	public String toString()
	{
		return this.ave + ", " + this.street;
	}
}
