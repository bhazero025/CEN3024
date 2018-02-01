package week04;

import java.util.ArrayList;

public class BusinessRuleEngine 
{

	private ArrayList<GasStation> gasStationList;
	
	public BusinessRuleEngine()
	{
		gasStationList = new ArrayList<>();
	}
	
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
