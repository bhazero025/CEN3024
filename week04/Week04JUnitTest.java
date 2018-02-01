package week04;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Tests the week04 application from the IDE or commandline using JUnit
 * @author Scott LaChance
 *
 */
public class Week04JUnitTest
{
	@Test
	public void testApplication()
	{
		BusinessRuleEngine engine = new BusinessRuleEngine();
		
		GasStation gas1 = new GasStation("Gas Station 1", new Location(-3,-2));
		GasStation gas2 = new GasStation("Gas Station 2", new Location(3,-2));
		GasStation gas3 = new GasStation("Gas Station 3", new Location(-5,3));
		
		try
		{
			engine.addGasStation(gas1);
			engine.addGasStation(gas2);
			engine.addGasStation(gas3);
			
			Location curLocation = new Location(4,3);
			GasStation nearest = engine.findNearestGasStation(curLocation);
			int distance = engine.calculateDistanceBetweenLocations(curLocation, nearest.getLocation());
			String msg = String.format("Found %s, distance %d", nearest, distance);
			trace(msg);
			assertTrue(nearest.equals(gas2));
			
			curLocation = new Location(-1,3);
			nearest = engine.findNearestGasStation(curLocation);
			distance = engine.calculateDistanceBetweenLocations(curLocation, nearest.getLocation());
			msg = String.format("Found %s, distance %d", nearest, distance);
			trace(msg);
			assertTrue(nearest.equals(gas3));
			
			curLocation = new Location(-5,-3);
			nearest = engine.findNearestGasStation(curLocation);
			distance = engine.calculateDistanceBetweenLocations(curLocation, nearest.getLocation());
			msg = String.format("Found %s, distance %d", nearest, distance);
			trace(msg);
			assertTrue(nearest.equals(gas1));
		}
		catch(IllegalArgumentException | InvalidLocationException ex)
		{
			ex.printStackTrace();
			fail(ex.getMessage());
		}
	}
	
	@Test
	public void testGasStationIllegalArgumentException()
	{
		BusinessRuleEngine engine = new BusinessRuleEngine();
		try
		{
			engine.addGasStation(null);
			fail("Expected IllegalArgumentException");
		}
		catch(IllegalArgumentException ex)
		{
			// This is OK
		}
		catch(InvalidLocationException ex)
		{
			// Failed, don't expect this exception
			fail("Don't expect InvalidLocationException");
		}
	}
	
	@Test
	public void testGasStationInvalidLocationException()
	{
		BusinessRuleEngine engine = new BusinessRuleEngine();
		try
		{
			engine.addGasStation(new GasStation("Invalid Location Station", new Location(-8, 5)));
			fail("Expected InvalidLocationException");
		}
		catch(IllegalArgumentException ex)
		{
			// Failed, don't expect this exception
			fail("Don't expect InvalidLocationException");		
		}
		catch(InvalidLocationException ex)
		{
			// This is OK
		}
	}
	
	@Test
	public void testLocationInvalidLocationException()
	{
		BusinessRuleEngine engine = new BusinessRuleEngine();
		try
		{
			engine.addGasStation(new GasStation("Invalid Location Station", new Location(-4, 3)));
			Location curLocation = new Location(-13,8);
			engine.findNearestGasStation(curLocation);
			fail("Expected InvalidLocationException");
		}
		catch(IllegalArgumentException ex)
		{
			// Failed, don't expect this exception
			fail("Don't expect InvalidLocationException");		
		}
		catch(InvalidLocationException ex)
		{
			// This is OK
		}
	}
	
	private void trace(String msg)
	{
		System.out.println(msg);
	}
}
