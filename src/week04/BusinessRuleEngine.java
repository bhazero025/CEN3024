package week04;

import java.util.ArrayList;

public class BusinessRuleEngine 
{

	private ArrayList<GasStation> gasStationList;
	
	/**
	 * Default constructor for BusinessEngine
	 * 
	 */
	public BusinessRuleEngine()
	{
		gasStationList = new ArrayList<>();
	}
	
	/**
	 * Adds a gas station
	 * @param gas the gas station to add
	 * @throws InvalidLocationException in case the location is out of bounds
	 */
	public void addGasStation(GasStation gas) throws InvalidLocationException 
	{
		if (gas == null)
		{
			throw new IllegalArgumentException();
		}
		if(gas.getLocation().getStreet() < -6 || gas.getLocation().getStreet() > 6 
				|| gas.getLocation().getAvenue() < -4 || gas.getLocation().getAvenue() > 4 
				|| gas.getLocation().getStreet() == 0 || gas.getLocation().getAvenue() == 0)
		{
			throw new InvalidLocationException();
		}
		
		gasStationList.add(gas);
	}

	/**
	 * Finds the nearest gas station
	 * @param curLocation the current location
	 * @return nearest gas station
	 * @throws InvalidLocationException when location is out of bounds
	 */
	public GasStation findNearestGasStation(Location curLocation) throws InvalidLocationException {
		if (curLocation == null || curLocation.getStreet() < -6 || curLocation.getStreet() > 6 || curLocation.getAvenue() < -4 || curLocation.getAvenue() > 4)
		{
			throw new InvalidLocationException();
		}
		
		int distance = Integer.MAX_VALUE;
		GasStation nearest = gasStationList.get(0);
		
		for(GasStation gas : gasStationList)
		{
			int curDistance = calculateDistanceBetweenLocations(curLocation, gas.getLocation());
			if (curDistance < distance)
			{
				distance = curDistance;
				nearest = gas;
			}
		}
		
		return nearest;
	}

	/**
	 * Calculates the distance between two locations
	 * @param curLocation current location
	 * @param location other location
	 * @return the distance
	 */
	public int calculateDistanceBetweenLocations(Location curLocation, Location location)
	{
        int x, y;
        x = curLocation.getStreet() - location.getStreet();
        y = curLocation.getAvenue() - location.getAvenue();
        x = Math.abs(x);
        y = Math.abs(y);
        return (x + y);
	}

}
