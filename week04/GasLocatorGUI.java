package week04;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Dylan Oszust
 * 
 * This class is the graphical user interface for the gas station locator app
 *
 */
public class GasLocatorGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	//List of Streets
	private String[] streets = new String[] {"East 6th Street", "East 5th Street",
			"East 4th Street", "East 3rd Street", "East 2nd Street", "East 1st Street",
			"West 1st Street", "West 2nd Street", "West 3rd Street", "West 4th Street",
			"West 5th Street", "West 6th Street"};
	
	//List of Avenues
	private String[] avenues = new String[] {"North 4th Avenue", "North 3rd Avenue",
			"North 2nd Avenue","North 1st Avenue", "South 1st Avenue", "South 2nd Avenue", "South 3rd Avenue", "South 4th Avenue"};
	
	//App Engine
	private BusinessRuleEngine m_engine = new BusinessRuleEngine();
	
	//Drop down menus for location selection
	private JComboBox cmbSelectGas1Ave = new JComboBox(avenues);
	private JComboBox cmbSelectLocationSt = new JComboBox(streets);
	private JComboBox cmbSelectLocationAve = new JComboBox(avenues);
	private JComboBox cmbSelectGas2Street = new JComboBox(streets);
	private JComboBox cmbSelectGas1Street = new JComboBox(streets);
	private JComboBox cmbSelectGas2Ave = new JComboBox(avenues);
	private JLabel lblInfo = new JLabel("");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GasLocatorGUI frame = new GasLocatorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GasLocatorGUI() {
		
		JButton btnFindNearestGas = new JButton("Find Nearest Gas Station");
		
		//Labels for the interface
		JLabel lblSetCurrentLocation = new JLabel("Set Current Location");
		JLabel lblSetGas1 = new JLabel("Set 1st Gas Station Location");
		JLabel lblSetGas2 = new JLabel("Set 2nd Gas Station Location");
		
		//General GUI Settings
		setTitle("Gas Station Locator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Select Current Location Items
		lblSetCurrentLocation.setBounds(10, 11, 197, 14);
		contentPane.add(lblSetCurrentLocation);				
		cmbSelectLocationSt.setBounds(217, 8, 127, 20);
		contentPane.add(cmbSelectLocationSt);		
		cmbSelectLocationAve.setBounds(354, 8, 127, 20);
		contentPane.add(cmbSelectLocationAve);
		
		//Select Gas 1 Items
		lblSetGas1.setBounds(10, 42, 197, 14);
		contentPane.add(lblSetGas1);		
		cmbSelectGas1Street.setBounds(217, 36, 127, 20);
		contentPane.add(cmbSelectGas1Street);		
		cmbSelectGas1Ave.setBounds(354, 36, 127, 20);
		contentPane.add(cmbSelectGas1Ave);
			
		//Select Gas 2 Items
		lblSetGas2.setBounds(10, 73, 197, 14);
		contentPane.add(lblSetGas2);		
		cmbSelectGas2Street.setBounds(217, 67, 127, 20);
		contentPane.add(cmbSelectGas2Street);				
		cmbSelectGas2Ave.setBounds(354, 67, 127, 20);
		contentPane.add(cmbSelectGas2Ave);
		
		//Button to run calculations
		btnFindNearestGas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getNearestGas();
			}
		});
		btnFindNearestGas.setBounds(217, 98, 264, 23);
		contentPane.add(btnFindNearestGas);		
		
		//Label to provide info to user
		lblInfo.setBounds(10, 130, 471, 91);
		contentPane.add(lblInfo);
	}
	
	//Gathers Information to run engine
	public void getNearestGas(){
		addFirstGasStation();
		addSecondGasStation();
		Location current = currentLocation();
		GasStation nearest;
		try {
			nearest = m_engine.findNearestGasStation(current); //runs engine to find gas station closest to current location
			showInfo(nearest, current);
		} catch (IllegalArgumentException | InvalidLocationException ex) {
			ex.printStackTrace();
		}
				
	}
	
	//Adds first gas station to engine
	public void addFirstGasStation(){
		String gas1St = cmbSelectGas1Street.getSelectedItem().toString();
		String gas1Ave = cmbSelectGas1Ave.getSelectedItem().toString();
		
		Location location = locate(gas1St, gas1Ave);
		GasStation gas1 = new GasStation("Gas Station 1", location);
		try {
			m_engine.addGasStation(gas1);
		} catch (IllegalArgumentException | InvalidLocationException e) {
			e.printStackTrace();
		}
		return;
	}
	
	//Adds second gas station to engine
	public void addSecondGasStation(){
		String gas2St = cmbSelectGas2Street.getSelectedItem().toString();
		String gas2Ave = cmbSelectGas2Ave.getSelectedItem().toString();
		
		Location location = locate(gas2St, gas2Ave);
		GasStation gas2 = new GasStation("Gas Station 2", location);
		try {
			m_engine.addGasStation(gas2);
		} catch (IllegalArgumentException | InvalidLocationException e) {
			e.printStackTrace();
		}
		return;
	}
	
	//Calculates current location from user input
	public Location currentLocation(){
		String currentSt = cmbSelectLocationSt.getSelectedItem().toString();
		String currentAve = cmbSelectLocationAve.getSelectedItem().toString();
				
		Location current = locate(currentSt, currentAve);
		return current;
	}
	
	//Translates user input into coordinates for engine use.
	public Location locate(String street, String avenue){
		int st = 0;
		int ave = 0;
		
	switch(street)
		{
			case "East 6th Street":
				st = 6;
				break;
			case "East 5th Street":
				st = 5;
				break;
			case "East 4th Street":
				st = 4;
				break;
			case "East 3rd Street":
				st = 3;
				break;
			case "East 2nd Street":
				st = 2;
				break;
			case "East 1st Street":
				st = 1;
				break;
			case "West 1st Street":
				st = -1;
				break;
			case "West 2nd Street":
				st = -2;
				break;
			case "West 3rd Street":
				st = -3;
				break;
			case "West 4th Street":
				st = -4;
				break;
			case "West 5th Street":
				st = -5;
				break;
			case "West 6th Street":
				st = -6;
				break;
		}
	
	switch(avenue)
		{
			case "North 4th Avenue":
				ave = 4;
				break;
			case "North 3rd Avenue":
				ave = 3;
				break;
			case "North 2nd Avenue":
				ave = 2;
				break;
			case "North 1st Avenue":
				ave = 1;
				break;
			case "South 1st Avenue":
				ave = -1;
				break;
			case "South 2nd Avenue":
				ave = -2;
				break;
			case "South 3rd Avenue":
				ave = -3;
				break;
			case "South 4th Avenue":
				ave = -4;
				break;
		}
		return new Location(st, ave);
	}
	
	//Produces info for user
	public void showInfo(GasStation nearest, Location current){
		int distance = m_engine.calculateDistanceBetweenLocations(current, nearest.getLocation());
		lblInfo.setText("The nearest gas station is " + nearest.getName() + " located "+ distance + " miles away!"); 
	}
}
