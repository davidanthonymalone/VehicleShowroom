/*
 * This is David Malone and Dylan Sages Programming project for Data Structures.
 * Vehicle showroom V1.0
 * 
 * 
 */



package dm_ds.wit.vehicleshowroom;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.JTextComponent;

import dm_ds.wit.vehicle.Vehicle;
import dm_ds.wit.vehiclecomparator.BHPComparator;
import dm_ds.wit.vehiclecomparator.BikeIdComparator;
import dm_ds.wit.vehiclecomparator.CarIdComparator;
import dm_ds.wit.vehiclecomparator.MakeComparator;
import dm_ds.wit.vehiclecomparator.ModelComparator;
import dm_ds.wit.vehiclecomparator.PriceComparator;
import dm_ds.wit.vehiclecomparator.SUVIdComparator;
import dm_ds.wit.vehiclecomparator.YearComparator;
import dm_ds.wit.vehicleexceptions.IdException;
import dm_ds.wit.vehicleexceptions.YearException;
import dm_ds.wit.vehicleio.FileHandlerBike;
import dm_ds.wit.vehicleio.FileHandlerCar;
import dm_ds.wit.vehicleio.FileHandlerSuv;



public class VehicleMuseumAL implements Serializable, ActionListener {
	
	
	// Declaring the Jcombo box
	private static final JComboBox MainS = null;
	
	// Declaring instances of the file handling class
	private FileHandlerCar fileHandlerC = new FileHandlerCar();
	private FileHandlerSuv fileHandlerS = new FileHandlerSuv();
	private FileHandlerBike fileHandlerB = new FileHandlerBike();
	Date date = new Date();

	// Giving the path for the images so that they will work when the jar file is on the desktop.
	private ImageIcon vehicleIcon = new ImageIcon(getClass().getResource("/HeadingLogo.png"));
	private ImageIcon adminIcon = new ImageIcon(getClass().getResource("/adminIcon.png"));
	private ImageIcon carIcon = new ImageIcon(getClass().getResource("/CarLogo.png"));
	private ImageIcon bikeIcon = new ImageIcon(getClass().getResource("/BikeLogo.png"));
	private ImageIcon suvIcon = new ImageIcon(getClass().getResource("/SUVLogo.png"));
	private ImageIcon jargonIcon = new ImageIcon(getClass().getResource("/jargon.png"));
	private ImageIcon updateIcon = new ImageIcon(getClass().getResource("/updateIcon.png"));
	private ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/deleteIcon.png"));
	private ImageIcon searchIcon = new ImageIcon(getClass().getResource("/searchIcon.png"));
	private static Icon blankIcon = new ImageIcon(); //Blank image icon
	
	
	
	//creating the array lists for the vehicles
	List<Car> carList = new ArrayList<Car>(5); //Creating a new ArrayList
	ArrayList<SUV> suvList = new ArrayList<SUV>(5);
	ArrayList<Bike> bikeList = new ArrayList<Bike>(5);


	Car a1 = new Car(1, "Nissan", "Skyline 2000 GT-R", 179, 1971, "Japanese",
		22000.00, 3 , 0); //Setting up predefined elements
	Car b1 = new Car(2, "Chevrolet", "Camaro Z/28", 350, 1969, "American",
			30000.00, 4 , 0);
	SUV a2 = new SUV(1, "Jeep", "Wrangler", 225, 1991, "American",
			25500.00,"Four Wheel Drive", 0); 
	SUV b2 = new SUV(2, "Land Rover", "Range Rover", 260, 1994, "English",
			29600.00,"Four Wheel Drive", 0); 
	Bike a3 = new Bike(1, "Kawasaki", "Ninja", 100, 1994, "Japanese",
			20000.00,900, 0);
	Bike b3 = new Bike(2, "Ducati", "Monster", 120, 1993, "Italian",
			22000.00,900, 0);


	@SuppressWarnings("unchecked")
	public VehicleMuseumAL() {
		fileHandlerS.setFileSUV();
		fileHandlerC.setFileCar();
		fileHandlerB.setFileBike();
		
		// The UI manager is used to change the colour of background/font
		UIManager.put("OptionPane.messageForeground", Color.white); //Coding to change colours of the GUI
		UIManager.put("Panel.background", new ColorUIResource(80, 80, 80));
		UIManager.put("OptionPane.background", new ColorUIResource(30, 30, 30));
		
		
		// Statement just to say if the file is not empty the carlist equals what is in the file.  If the file is empty there will be two predefined elements added to the arraylist.
		if(!fileHandlerC.isFileEmpty())
		{
	    	carList = (List<Car>) fileHandlerC.readFromFile(Car.class);
	    		    	 	
	    }else
	    	{
	   
		carList.add(a1); //Adding predefined elements to array list
		carList.add(b1);
		

	}
		 if(!fileHandlerS.isFileEmpty())
		   {
			 suvList = (ArrayList<SUV>) fileHandlerS.readFromFile(SUV.class);
			
		   }
		   else
		   {
				suvList.add(a2);		
				suvList.add(b2);
 	   }
		 
		 if(!fileHandlerB.isFileEmpty())
		   {

			 bikeList = (ArrayList<Bike>) fileHandlerB.readFromFile(Bike.class);
		   }
		   else
		   {
				bikeList.add(a3);
				bikeList.add(b3);
		   }
				
	}

//####################################################################################################################
	// this class is the first class the user will see upon the running of the program.
	public int menuMain() { 
		
		int choose = 0; 
		String cho1 = new String("1. Add a Vehicle:");
		String cho2 = new String("2. Search for Vehicle:");
		String cho3 = new String("3. List Vehicles:");
		String cho4 = new String("4. Delete a Vehicle:");
		String cho5 = new String("5. Update a Vehicle:");
		String cho6 = new String("6. Search by certain attributes:");
		String cho7 = new String("7. Sort and List by certain attibutes");
		String cho8 = new String("8. Jargon Buster");
		String cho9 = new String("9. Exit system & Save Data:");
		String msg = new String("Enter Option:");
		JTextField cho = new JTextField(""); //allows user to enter option in GUI

		Object message[] = new Object[13];//create object of message with a max size of 13.
		
		message[0] = vehicleIcon;
		message[1] = cho1;
		message[2] = cho2;
		message[3] = cho3;
		message[4] = cho4;
		message[5] = cho5;
		message[6] = cho6;
		message[7] = cho7;
		message[8] = cho8;
		message[9] = cho9;
		message[10] = msg;
		message[11] = cho;
		message[12] = date.toString();


		int response = JOptionPane.showConfirmDialog(null, message,
				"Modern Classics Museum Showcase", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, blankIcon); 

		if (response == JOptionPane.CANCEL_OPTION)
		{
		choose = 9; // if user enters 9 program shuts down
		}
		else {//If option is selected will either give an error if 1-6 is not selected or will execute desired option
			try { //Program will try and run this code
				choose = Integer.parseInt(cho.getText()); //If 1-6 is selected desired option is run
			}			
			catch (NumberFormatException e) {
				JOptionPane
				.showMessageDialog(
						null,
						"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid option.", "Invalid Entry",0);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again", "General Error", 0);

			}
		}

		return choose; //Return the value entered
	}

//##############################################################################################################################
	//This method takes input from the user and writes the car object to the array list.
	@SuppressWarnings("unused")
	public void menuAddCar() { 
		// code that the admin has to enter the password to add or delete a car.
		int seccode = 1234;
		String code = (String) JOptionPane.showInputDialog(null, "Please enter the admin code: ", "Admin Input", 0,adminIcon, null, "Enter Code Here");
		if (Integer.parseInt(code) == 1234)
		{
			{
				String[] numOfDoors = { "3", "5", "7"};
				JComboBox doorsNumber = new JComboBox(numOfDoors);
				doorsNumber.setSelectedIndex(2);
				doorsNumber.addActionListener(this);
		String msgMake = new String("Car Make:");
		String msgModel = new String("Car Model:");
		String msgBHP = new String("Car BHP:");
		String msgCost = new String("Car Cost:");
		String msgDoor = new String("Car Door Number:");
		String msgYear = new String("Car Year: (1800-1995)");
		String msgNation = new String("Car Nationality:");
		JTextField make = new JTextField("");
		JTextField model = new JTextField("");
		JTextField bhp = new JTextField("");
		JTextField price = new JTextField("");
		JTextField door = new JTextField("");
		JTextField year = new JTextField("");
		JTextField nation = new JTextField("");

		Object message[] = new Object[16];

		message[0] = carIcon;
		message[1] = msgMake;
		message[2] = make;
		message[3] = msgModel;
		message[4] = model;
		message[5] = msgBHP;
		message[6] = bhp;
		message[7] = msgCost;
		message[8] = price;
		message[9] = msgDoor;
		message[10] = doorsNumber;
		message[11] = msgYear;
		message[12] = year;
		message[13] = msgNation;
		message[14] = nation;
		message[15] = date.toString();

		
	
		int response = JOptionPane.showConfirmDialog(null, message,
				"Car Museum Entry", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, blankIcon);

		if (response == JOptionPane.CANCEL_OPTION)
			;
		{
			try {
				{
					if (Integer.parseInt(year.getText()) > 1995 || Integer.parseInt(year.getText()) < 1800) { //while the car is greater than 1995 or older than 1800 
						throw new YearException();
						
						
					} else { //runs while year entered is applicable to the program
						 int id;
						 int doorNum1 = 0;

							
							doorNum1 = Integer.parseInt((String) doorsNumber.getSelectedItem());

						carList.add(new Car(id=carList.size()+1, make.getText(),
								model.getText(),
								Integer.parseInt(bhp.getText()), Integer
								.parseInt(year.getText()), nation.getText(),
								Double
								.parseDouble(price.getText()), doorNum1, response)); //adds the new details to a new car
						JOptionPane.showMessageDialog(null, "You have created and car your car ID is " + id);

												   
						  }
					}
					fileHandlerC.writeToFile(carList);
				}
			
			catch (NumberFormatException e) {
				JOptionPane
				.showMessageDialog(
						null,
						"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid option.", "Invalid Entry",0);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again", "General Error", 0);

			}
		}
			}
		
		}
		else
		{
		JOptionPane.showMessageDialog(null,"I'm sorry, you do not have admin rights..", "Not an Admin", 0);
		}
	}
//########################################################################################################################
	
	// same method as car but for bike
	public void menuAddBike() { 
		int seccode = 1234;
		String code = (String) JOptionPane.showInputDialog(null, "Please enter the admin code: ", "Admin Input", 0,adminIcon, null, "Enter Code Here");
		if (Integer.parseInt(code) == 1234)
		{
			{
		String msgMake = new String("Motorbike Make: (String)");
		String msgModel = new String("Motorbike Model: (String)");
		String msgBHP = new String("Motorbike BHP: (int)");
		String msgCost = new String("Motorbike Cost: (Double)");
		String msgcc = new String("Motorbike engine cc: (int)");
		String msgYear = new String("Motorbike Year: (int, 1800-1995)");
		String msgNation = new String("Motorbike Nationality: (String)");
		JTextField make = new JTextField("");
		JTextField model = new JTextField("");
		JTextField bhp = new JTextField("");
		JTextField price = new JTextField("");
		JTextField cc = new JTextField("");
		JTextField year = new JTextField("");
		JTextField nation = new JTextField("");

		Object message[] = new Object[16];

		message[0] = bikeIcon;
		message[1] = msgMake;
		message[2] = make;
		message[3] = msgModel;
		message[4] = model;
		message[5] = msgBHP;
		message[6] = bhp;
		message[7] = msgCost;
		message[8] = price;
		message[9] = msgcc;
		message[10] = cc;
		message[11] = msgYear;
		message[12] = year;
		message[13] = msgNation;
		message[14] = nation;
		message[15] = date.toString();

		
		
		int response = JOptionPane.showConfirmDialog(null, message,
				"Bike Museum Entry", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, blankIcon);

		if (response == JOptionPane.CANCEL_OPTION);
		{
			try {
				{
					if (Integer.parseInt(year.getText()) > 1995 || Integer.parseInt(year.getText()) < 1800) 
					{ //while the car is greater than 1995 or older than 1800 
						throw new YearException();

					} else 
					{ //runs while year entered is applicable to the program
						int id;
						bikeList.add(new Bike(id=bikeList.size()+1, make.getText(),
								model.getText(),
								Integer.parseInt(bhp.getText()), Integer
								.parseInt(year.getText()), nation.getText(),Double
								.parseDouble(price.getText()), Integer
								.parseInt(cc.getText()), response)); //adds the new details to a new car
						JOptionPane.showMessageDialog(null, "You have created and bike your bike ID is " + id);
	
					}	
					fileHandlerB.writeToFile(bikeList);

					
			}
			}
			catch (NumberFormatException e) {
				JOptionPane
				.showMessageDialog(
						null,
						"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid option.", "Invalid Entry",0);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again", "General Error", 0);

			}
			}
				}
			
			}
			else
			{
				JOptionPane.showMessageDialog(null,"I'm sorry, you do not have admin rights..", "Not an admin",0);

			}
		}
//########################################################################################################		
// the add method for SUV
	public void menuAddSUV() 
			{ 
				int seccode = 1234;
				String code = (String) JOptionPane.showInputDialog(null, "Please enter the admin code: ", "Admin Input", 0,adminIcon, null, "Enter Code Here");
				if (Integer.parseInt(code) == 1234)
				{
					{
						
						
					
						String[] wheeldrive = {"Rear Wheel Drive", "Front Wheel Drive", "Four Wheel Drive"};
						JComboBox drivetype = new JComboBox(wheeldrive);
						drivetype.setSelectedIndex(2);
						drivetype.addActionListener(this);
				String msgMake = new String("SUV Make: (String)");
				String msgModel = new String("SUV Model: (String)");
				String msgBHP = new String("SUV BHP: (int)");
				String msgCost = new String("SUV Cost: (Double)");
				String msgdrivetrain = new String("SUV drivetrain: (String)");
				String msgYear = new String("SUV Year: (int, 1800-1995)");
				String msgNation = new String("SUV Nationality: (String)");
				JTextField make = new JTextField("");
				JTextField model = new JTextField("");
				JTextField bhp = new JTextField("");
				JTextField price = new JTextField("");
				JTextField drivetrain = new JTextField("");
				JTextField year = new JTextField("");
				JTextField nation = new JTextField("");

				Object message[] = new Object[16];

				message[0] = suvIcon;
				message[1] = msgMake;
				message[2] = make;
				message[3] = msgModel;
				message[4] = model;
				message[5] = msgBHP;
				message[6] = bhp;
				message[7] = msgCost;
				message[8] = price;
				message[9] = msgdrivetrain;
				message[10] = drivetype;
				message[11] = msgYear;
				message[12] = year;
				message[13] = msgNation;
				message[14] = nation;
				message[15] = date.toString();

				
				
				int response = JOptionPane.showConfirmDialog(null, message,
						"SUV Museum Entry", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, blankIcon);

				if (response == JOptionPane.CANCEL_OPTION)
					;
				{
					try {
						{
							if (Integer.parseInt(year.getText()) > 1995 || Integer.parseInt(year.getText()) < 1800) { //while the car is greater than 1995 or older than 1800 
								throw new YearException();
							} else { //runs while year entered is applicable to the program
								// SUV(int, String, String, int, int, String, double, int, int)
								int id;
				                String Drive = (String) drivetype.getSelectedItem();

								suvList.add(new SUV(id=suvList.size()+1, make.getText(),
										model.getText(),
										Integer.parseInt(bhp.getText()), Integer
										.parseInt(year.getText()), nation.getText(),Double
										.parseDouble(price.getText()), Drive, response)); //adds the new details to a new car
								JOptionPane.showMessageDialog(null, "You have created and SUV your SUV ID is " + id);

							}
							fileHandlerS.writeToFile(suvList);
						}
					}
		

					catch (NumberFormatException e) {
						JOptionPane
						.showMessageDialog(
								null,
								"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid option.", "Invalid Entry",0);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Data Input Error" + e
								+ "\nPlease Try Again", "General Error", 0);

					}
		}
			}
		
		}
		else
		{
			JOptionPane.showMessageDialog(null,"I'm sorry, you do not have admin rights..", "Not an Admin",0);

		}
	}

//#############################################################################################################
	public void menuShowCar() {
		{
			String searchfor = (String) JOptionPane.showInputDialog(null, "Please enter the car to show: ", "Car Search", 0,searchIcon, null, "Enter Car ID Here");
			//Asks user to enter a car ID for search
			boolean find = false; //declare boolean is false
			int i = 0; //creating int i
			try {
				while (!find && (carList.get(i) != null)) {//while carList is not empty
					if (Integer.parseInt(searchfor) == (carList.get(i)
							.getCarId())) {//If there is a match between ID entered and ID in ArrayList
						JOptionPane.showMessageDialog(null, carList.get(i)); //Show details of the car found
						find = true;
					}

					i++; //adding one to i each time to search through ArrayList
				}

				if (!find) //If it cannot find the boolean{
					throw new IdException(); // throws exception if the id is not found

			}
			catch (IndexOutOfBoundsException e) {
				JOptionPane
				.showMessageDialog(null,
						"You have entered an invalid Car ID. Please enter a valid ID.", "Invalid ID", 0);
			}

			catch (NumberFormatException e) {
				JOptionPane
				.showMessageDialog(
						null,
						"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid ID.", "Invalid Entry",0);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again", "General Error", 0);

			}
		}
		}
	
				
//###################################################################################################################
	public void menuSearchModel() {
		{
String searchmodel = (String) JOptionPane.showInputDialog(null, "Please enter the model you wish to search for:", "Model Search", 0,searchIcon, null, "Enter Model of Vehicle Here"); //declare boolean is false
int i=0;
int ii=0;
int iii=0;
JOptionPane.showMessageDialog(null,"You will be returned to main menu if you enter incorrect Model");
	try
	{
while (i < carList.size()) {
	 boolean model = carList.get(i).getModel().toLowerCase().contains(searchmodel.toLowerCase());
if (model==true)
{
JOptionPane.showMessageDialog(null,carList.get(i));//Show details of the car found						    
}
else if(carList.get(i).getModel().contains(searchmodel)==false)
{

}

i++;
}

while (ii < bikeList.size()) {
	 boolean model1 = bikeList.get(ii).getModel().toLowerCase().contains(searchmodel.toLowerCase());
	if (model1==true)
	{
	JOptionPane.showMessageDialog(null,bikeList.get(ii));//Show details of the car found						    
	}
	else if(ii>bikeList.size())
	{

	}

	ii++;
}


while (iii < suvList.size()) {
	 boolean model2 = suvList.get(iii).getModel().toLowerCase().contains(searchmodel.toLowerCase());
	if (model2==true)
	{
	JOptionPane.showMessageDialog(null,suvList.get(iii));//Show details of the car found						    
	}
	else if(suvList.get(iii).getModel().contains(searchmodel))
	{

	}

	iii++;

}

	}

			catch (NullPointerException  e) {
				JOptionPane
				.showMessageDialog(null,
						"You have entered an invalid Make. Please enter a valid Make.", "Invalid Make", 0);
			}

			catch (NumberFormatException e) {
				JOptionPane
				.showMessageDialog(
						null,
						"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid Make.", "Invalid Entry",0);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again", "General Error", 0);

			}
			
		}
		}
	
	
	// method that allows you to search the list by nation.
	public void menuSearchNation() {
		{
String searchnation = (String) JOptionPane.showInputDialog(null, "Please enter the nationality you wish to search for:", "Nationality Search", 0,searchIcon, null, "Enter Nationality of Vehicle Here"); //declare boolean is false
int i=0;
int ii=0;
int iii=0;
JOptionPane.showMessageDialog(null,"You will be returned to main menu if you enter incorrect nationality");
	try
	{
while (i < carList.size()) {
	 boolean nation = carList.get(i).getNation().toLowerCase().contains(searchnation.toLowerCase());
if (nation==true)
{
JOptionPane.showMessageDialog(null,carList.get(i));//Show details of the car found						    
}
else if(carList.get(i).getNation().contains(searchnation)==false)
{

}

i++;
}

while (ii < bikeList.size()) {
	 boolean nation1 = bikeList.get(ii).getNation().toLowerCase().contains(searchnation.toLowerCase());
	if (nation1==true)
	{
	JOptionPane.showMessageDialog(null,bikeList.get(ii));//Show details of the car found						    
	}
	else if(ii>bikeList.size())
	{

	}

	ii++;
}


while (iii < suvList.size()) {
	 boolean nation2 = suvList.get(iii).getNation().toLowerCase().contains(searchnation.toLowerCase());
	if (nation2==true)
	{
	JOptionPane.showMessageDialog(null,suvList.get(iii));//Show details of the car found						    
	}
	else if(suvList.get(iii).getNation().contains(searchnation))
	{

	}

	iii++;

}

	}

			catch (NullPointerException  e) {
				JOptionPane
				.showMessageDialog(null,
						"You have entered an invalid Make. Please enter a valid Make.", "Invalid Make", 0);
			}

			catch (NumberFormatException e) {
				JOptionPane
				.showMessageDialog(
						null,
						"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid Make.", "Invalid Entry",0);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again", "General Error", 0);

			}
			
		}
		}
	public void menuShowBike() {
		{
			String searchfor = (String) JOptionPane.showInputDialog(null, "Please enter the bike to show: ", "Bike Search", 0,searchIcon, null, "Enter Bike ID Here");
			boolean find = false; //declare boolean is false
			int i = 0; //creating int i
			try {
				while (!find && (bikeList.get(i) != null)) {//while carList is not empty
					if (Integer.parseInt(searchfor) == (bikeList.get(i).getBikeId())) 
					{//If there is a match between ID entered and ID in ArrayList
						JOptionPane.showMessageDialog(null, bikeList.get(i)); //Show details of the car found
						find = true;
					}

					i++; //adding one to i each time to search through ArrayList
				}
			

				if (!find) //If it cannot find the boolean{
					JOptionPane.showMessageDialog(null,
							"Sorry that ID does not exist"); //show it does not exist

			}
			catch (IndexOutOfBoundsException e) {
				JOptionPane
				.showMessageDialog(null,
						"You have entered an invalid Bike ID. Please enter a valid ID.", "Invalid ID", 0);
			}

			catch (NumberFormatException e) {
				JOptionPane
				.showMessageDialog(
						null,
						"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid ID.", "Invalid Entry",0);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again", "General Error", 0);

			}
		}
		}
	
	

	
	public void menuShowSUV() {
		{
			String searchfor = (String) JOptionPane.showInputDialog(null, "Please enter the SUV to show: ", "SUV Search", 0,searchIcon, null, "Enter SUV ID Here");
			boolean find = false; //declare boolean is false
			int i = 0; //creating int i
			try {
				while (!find && (suvList.get(i) != null)) {//while carList is not empty
					if (Integer.parseInt(searchfor) == (suvList.get(i)
							.getSUVId())) {//If there is a match between ID entered and ID in ArrayList
						JOptionPane.showMessageDialog(null, suvList.get(i)); //Show details of the car found
						find = true;
					}

					i++; //adding one to i each time to search through ArrayList
				}

				if (!find) //If it cannot find the boolean{
					JOptionPane.showMessageDialog(null,
							"Sorry that ID does not exist"); //show it does not exist

			}
			catch (IndexOutOfBoundsException e) {
				JOptionPane
				.showMessageDialog(null,
						"You have entered an invalid SUV ID. Please enter a valid ID.", "Cannot find ID", 0);
			}

			catch (NumberFormatException e) {
				JOptionPane
				.showMessageDialog(
						null,
						"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid ID.", "Invalid Entry",0);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again", "General Error", 0);

			}
		}
		}
	

	
	public void menuListVehicle(){
		Collections.sort(carList,new CarIdComparator());
		JOptionPane.showMessageDialog(null, carList); 
		Collections.sort(bikeList,new BikeIdComparator());
		JOptionPane.showMessageDialog(null, bikeList);
		Collections.sort(suvList,new SUVIdComparator());
		JOptionPane.showMessageDialog(null, suvList);
			}

	public void menuListCar(){
		
		Collections.sort(carList,new CarIdComparator());
		JOptionPane.showMessageDialog(null, carList); 
			}
	
		
	public void menuListBike(){
		Collections.sort(bikeList,new BikeIdComparator());
		JOptionPane.showMessageDialog(null, bikeList);
				}
			
	public void menuListSUV(){
		Collections.sort(suvList,new SUVIdComparator());
		JOptionPane.showMessageDialog(null, suvList);
					}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////
	public void menuRemoveCar() {
		int seccode = 1234;
		String code = (String) JOptionPane.showInputDialog(null, "Please enter the admin code: ", "Admin Input", 0,adminIcon, null, "Enter Code Here");
		if (Integer.parseInt(code) == 1234)
		{
		String deleteCar = (String) JOptionPane.showInputDialog(null, "Please enter the ID of Car you would like to delete: ", "Car Delete", 0,deleteIcon, null, "Enter Car ID to delete here");
		try {

			
			int cancel = Integer.parseInt(deleteCar);

			Iterator<Car> ca = carList.iterator();

			while (ca.hasNext())

				// when the id in the array is equal to cancel it will be removed
				if (ca.next().getCarId() == cancel) {
					ca.remove();

					JOptionPane.showMessageDialog(null, "The car has been deleted ");
					break;
					// if there is no id in the array of that value then its false and cant be done
				} else if (ca.hasNext() == false)

				{
					JOptionPane.showMessageDialog(null, "ID does not exist", "Invalid ID", 0);
					break;
				}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid ID.", "Invalid Entry",0);

		}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"I'm sorry, you do not have admin rights..", "Not an Admin", 0);
		}
		fileHandlerC.writeToFile(carList);

	}

	public void menuRemoveBike()
	{
		int seccode = 1234;
		String code = (String) JOptionPane.showInputDialog(null, "Please enter the admin code: ", "Admin Input", 0,adminIcon, null, "Enter Code Here");
		if (Integer.parseInt(code) == 1234)
		{
		String deleteBike = (String) JOptionPane.showInputDialog(null, "Please enter the ID of Bike you would like to delete: ", "Bike Delete", 0,deleteIcon, null, "Enter Bike ID to delete here");

		try 
		{
			int cancel = Integer.parseInt(deleteBike);
			Iterator<Bike> bi = bikeList.iterator();
			while (bi.hasNext())

				// when the id in the array is equal to cancel it will be removed
				if (bi.next().getBikeId() == cancel) {
					bi.remove();

					JOptionPane.showMessageDialog(null, "The bike has been deleted ");
					break;
					// if there is no id in the array of that value then its false and cant be done
				} else if (bi.hasNext() == false)

				{
					JOptionPane.showMessageDialog(null, "ID does not exist", "Invalid ID", 0);
					break;
				}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid ID.", "Invalid Entry",0);
					
		}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"I'm sorry, you do not have admin rights..", "Not an Admin", 0);
		}
		fileHandlerB.writeToFile(bikeList);

	}
	
	
	public void menuRemoveSUV()
	{
		int seccode = 1234;
		String code = (String) JOptionPane.showInputDialog(null, "Please enter the admin code: ", "Admin Input", 0,adminIcon, null, "Enter Code Here");
		if (Integer.parseInt(code) == 1234)
		{
		String deleteSUV = (String) JOptionPane.showInputDialog(null, "Please enter the ID of SUV you would like to delete: ", "SUV Delete", 0,deleteIcon, null, "Enter SUV ID  to delete here");

		try {

			
			int cancel = Integer.parseInt(deleteSUV);

			Iterator<SUV> su = suvList.iterator();

			while (su.hasNext())

				// when the id in the array is equal to cancel it will be removed
				if (su.next().getSUVId() == cancel) {
					su.remove();

					JOptionPane.showMessageDialog(null, "The SUV has been deleted ");
					break;
					// if there is no id in the array of that value then its false and cant be done
				} else if (su.hasNext() == false)

				{
					JOptionPane.showMessageDialog(null, "ID does not exist", "Invalid ID",0);
					break;
				}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid ID.", "Invalid Entry",0);
		}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"I'm sorry, you do not have admin rights..", "Not an Admin", 0);
		}
		fileHandlerS.writeToFile(suvList);

	}// /////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// This is the update method for the Car
	public void menuUpdateCar() { 
		int seccode = 1234;
		String code = (String) JOptionPane.showInputDialog(null, "Please enter the admin code: ", "Admin Input", 0,adminIcon, null, "Enter Code Here");
		if (Integer.parseInt(code) == 1234)
		{
		try {
			String upd = (String) JOptionPane.showInputDialog(null, "Please enter the car ID to update: ", "Car Update", 0,updateIcon, null, "Enter Car ID here");
			for(int i=0;i<carList.size();i++)
			{
			 if(Integer.parseInt(upd) == (carList.get(i).getCarId())) 
			{ //If the carList is not empty
				 
				 
				 // picking the number of doors.
				String[] numOfDoors = { "3", "5", "7"};
				JComboBox doorsNumber = new JComboBox(numOfDoors);
				doorsNumber.setSelectedIndex(2);
				doorsNumber.addActionListener(this);
				String upmsgMake = new String("Car Make -- It was previously: " + carList.get(i).getMake());
				String upmsgModel = new String("Car Model -- It was previously: " + carList.get(i).getModel());
				String upmsgBHP = new String("Car BHP -- It was previously: " + carList.get(i).getBhp());
				String upmsgCost = new String("Car Cost -- It was previously: " + carList.get(i).getPrice());
				String upmsgDoor = new String("Car Door Number -- It was previously: " + carList.get(i).getDoor());
				String upmsgYear = new String("Car Year (1800-1995) -- It was previously: " + carList.get(i).getYear());
				String upmsgNation = new String("Car Nationality -- It was previously: " + carList.get(i).getNation());
				JTextField upmake = new JTextField("");
				JTextField upmodel = new JTextField("");
				JTextField upbhp = new JTextField("");
				JTextField upprice = new JTextField("");
				JTextField upyear = new JTextField("");
				JTextField upnation = new JTextField("");

				Object message[] = new Object[16];

				message[0] = carIcon;
				message[1] = upmsgMake;
				message[2] = upmake;
				message[3] = upmsgModel;
				message[4] = upmodel;
				message[5] = upmsgBHP;
				message[6] = upbhp;
				message[7] = upmsgCost;
				message[8] = upprice;
				message[9] = upmsgDoor;
				message[10] = doorsNumber;
				message[11] = upmsgYear;
				message[12] = upyear;
				message[13] = upmsgNation;
				message[14] = upnation;
				message[15] = date.toString();


				int response = JOptionPane.showConfirmDialog(null, message,
						"Car Museum Entry", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, blankIcon);

				if (response == JOptionPane.CANCEL_OPTION)
					;
				{
					if (Integer.parseInt(upyear.getText()) > 1995 || Integer.parseInt(upyear.getText()) < 1800) { //while the car is greater than 1995 or older than 1800 
						throw new YearException(); //throws an exception for the car the if the details are not applicable to the system
					}
					else{
						int doorNum1 = Integer.parseInt((String)doorsNumber.getSelectedItem());

					String make = (upmake.getText()); //getting the text entered at upmake and equalling it to the String make
					carList.get(i).setMake(make); //Setting the new car make
					// updates the cars attributes.
					String model = (upmodel.getText());
					carList.get(i).setModel(model);
					
					int bhp = Integer.parseInt(upbhp.getText());
					carList.get(i).setBhp(bhp);

					double price = Double.parseDouble(upprice.getText());
					carList.get(i).setPrice(price);
					
					int door=doorNum1;
					carList.get(i).setDoor(door);

					int year = Integer.parseInt(upyear.getText());
					carList.get(i).setYear(year);

					String nation = (upnation.getText());
					carList.get(i).setNation(nation);
					}
				}
				
			} 
		
			{ 
			}
		}
		
		
		}
		
		catch (IndexOutOfBoundsException e) {
			JOptionPane
			.showMessageDialog(null,
					"You have entered an invalid Car ID. Please enter a valid ID.", "Cannot find ID", 0);
		}

		catch (NumberFormatException e) {
			JOptionPane
			.showMessageDialog(
					null,
					"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid ID.", "Invalid Entry",0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data Input Error" + e
					+ "\nPlease Try Again", "General Error", 0);

		}
	}
	
	else
		{
		JOptionPane.showMessageDialog(null,"I'm sorry, you do not have admin rights..", "Not an Admin", 0);
		}
		fileHandlerC.writeToFile(carList);

	}
	// updates the bike 
	public void menuUpdateBike()
	{
		int seccode = 1234;
		String code = (String) JOptionPane.showInputDialog(null, "Please enter the admin code: ", "Admin Input", 0,adminIcon, null, "Enter Code Here");
		if (Integer.parseInt(code) == 1234)
		{
		try {

			String upd = (String) JOptionPane.showInputDialog(null, "Please enter the bike ID to update: ", "Bike Update", 0,updateIcon, null, "Enter Bike ID here");
			
			for(int i=0;i<bikeList.size();i++)
			{
			if (Integer.parseInt(upd) == (bikeList.get(i).getBikeId())) { //If the carList is not empty
				String upmsgMake = new String("Bike Make -- It was previously: " + bikeList.get(i).getMake());
				String upmsgModel = new String("Bike Model -- It was previously: " + bikeList.get(i).getModel());
				String upmsgBHP = new String("Bike BHP -- It was previously: " + bikeList.get(i).getBhp());
				String upmsgCost = new String("Bike Cost -- It was previously: " + bikeList.get(i).getPrice());
				String upmsgCc = new String("Bike Engine cc -- It was previously: " + bikeList.get(i).getEnginecc());
				String upmsgYear = new String("Bike Year (1800-1995) -- It was previously: " + bikeList.get(i).getYear());
				String upmsgNation = new String("Bike Nationality -- It was previously: " + bikeList.get(i).getNation());
				JTextField upmake = new JTextField();
				JTextField upmodel = new JTextField();
				JTextField upbhp = new JTextField();
				JTextField upprice = new JTextField();
				JTextField upcc = new JTextField();
				JTextField upyear = new JTextField();
				JTextField upnation = new JTextField();

				Object message[] = new Object[16];

				message[0] = bikeIcon;
				message[1] = upmsgMake;
				message[2] = upmake;
				message[3] = upmsgModel;
				message[4] = upmodel;
				message[5] = upmsgBHP;
				message[6] = upbhp;
				message[7] = upmsgCost;
				message[8] = upprice;
				message[9] = upmsgCc;
				message[10] = upcc;
				message[11] = upmsgYear;
				message[12] = upyear;
				message[13] = upmsgNation;
				message[14] = upnation;
				message[15] = date.toString();


				int response = JOptionPane.showConfirmDialog(null, message,
						"Car Museum Entry", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, blankIcon);

				if (response == JOptionPane.CANCEL_OPTION)
					;
				{
					if (Integer.parseInt(upyear.getText()) >= 1995 || Integer.parseInt(upyear.getText()) <= 1800) { //while the car is greater than 1995 or older than 1800 
						throw new YearException(); //throws an exception for the car the if the details are not applicable to the system
					}
					else{
					String make = (upmake.getText()); //getting the text entered at upmake and equalling it to the String make
					bikeList.get(i).setMake(make); //Setting the new car make

					String model = (upmodel.getText());
					bikeList.get(i).setModel(model);

					int bhp = Integer.parseInt(upbhp.getText());
					bikeList.get(i).setBhp(bhp);

					double price = Double.parseDouble(upprice.getText());
					bikeList.get(i).setPrice(price);
					
					int cc = Integer.parseInt(upcc.getText());
					bikeList.get(i).setEnginecc(cc);

					int year = Integer.parseInt(upyear.getText());
					bikeList.get(i).setYear(year);

					String nation = (upnation.getText());
					bikeList.get(i).setNation(nation);
					//i++ to search through the array
					}
				}
			} 
			else 
			{ //if invalid ID is entered
				 //confirm this to user
			}
		}
		}

		catch (IndexOutOfBoundsException e) {
			JOptionPane
			.showMessageDialog(null,
					"You have entered an invalid Bike ID. Please enter a valid ID.", "Cannot find ID", 0);
		}

		catch (NumberFormatException e) {
			JOptionPane
			.showMessageDialog(
					null,
					"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid ID.", "Invalid Entry",0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data Input Error" + e
					+ "\nPlease Try Again", "General Error", 0);

		}
	}
	
	else
		{
		JOptionPane.showMessageDialog(null,"I'm sorry, you do not have admin rights..", "Not an Admin", 0);
		}
		fileHandlerB.writeToFile(bikeList);

	}
	
	
	// same as above the user can update the vehicle, which in this case is the SUV
	public void menuUpdateSUV()
	{
		int seccode = 1234;
		String code = (String) JOptionPane.showInputDialog(null, "Please enter the admin code: ", "Admin Input", 0,adminIcon, null, "Enter Code Here");
		if (Integer.parseInt(code) == 1234)
		{
		try {

			String[] wheeldrive = {"Rear Wheel Drive", "Front Wheel Drive", "Four Wheel Drive"};
			JComboBox drivetype = new JComboBox(wheeldrive);
			drivetype.setSelectedIndex(2);
			drivetype.addActionListener(this);
			String upd = (String) JOptionPane.showInputDialog(null, "Please enter the SUV ID to update: ", "SUV Update", 0,updateIcon, null, "Enter SUV ID here");
			
			for(int i=0;i<suvList.size();i++)
			{
			if (Integer.parseInt(upd) == (suvList.get(i).getSUVId())) { //If the carList is not empty

				String upmsgMake = new String("SUV Make -- It was previously: " + suvList.get(i).getMake());
				String upmsgModel = new String("SUV Model -- It was previously: " + suvList.get(i).getModel());
				String upmsgBHP = new String("SUV BHP -- It was previously: " + suvList.get(i).getBhp());
				String upmsgCost = new String("SUV Cost -- It was previously: " + suvList.get(i).getPrice());
				String upmsgDrivetrain = new String("SUV drivetrain -- It was previously: " + suvList.get(i).getDrivetrain());
				String upmsgYear = new String("SUV Year (1800-1995) -- It was previously: " + suvList.get(i).getYear());
				String upmsgNation = new String("SUV Nationality -- It was previously: " + suvList.get(i).getNation());
				JTextField upmake = new JTextField("");
				JTextField upmodel = new JTextField("");
				JTextField upbhp = new JTextField("");
				JTextField upprice = new JTextField("");
				JTextField updrivetrain = new JTextField("");
				JTextField upyear = new JTextField("");
				JTextField upnation = new JTextField("");

				Object message[] = new Object[16];

				message[0] = suvIcon;
				message[1] = upmsgMake;
				message[2] = upmake;
				message[3] = upmsgModel;
				message[4] = upmodel;
				message[5] = upmsgBHP;
				message[6] = upbhp;
				message[7] = upmsgCost;
				message[8] = upprice;
				message[9] = upmsgDrivetrain;
				message[10] = drivetype;
				message[11] = upmsgYear;
				message[12] = upyear;
				message[13] = upmsgNation;
				message[14] = upnation;
				message[15] = date.toString();


				int response = JOptionPane.showConfirmDialog(null, message,
						"Car Museum Entry", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, blankIcon);

				if (response == JOptionPane.CANCEL_OPTION)
					;
				{
					if (Integer.parseInt(upyear.getText()) >= 1995 || Integer.parseInt(upyear.getText()) <= 1800) { //while the car is greater than 1995 or older than 1800 
						throw new YearException(); //throws an exception for the car the if the details are not applicable to the system
					}
					else{
		                String Drive = (String) drivetype.getSelectedItem();
					String make = (upmake.getText()); //getting the text entered at upmake and equalling it to the String make
					suvList.get(i).setMake(make); //Setting the new car make

					String model = (upmodel.getText());
					suvList.get(i).setModel(model);

					int bhp = Integer.parseInt(upbhp.getText());
					suvList.get(i).setBhp(bhp);

					double price = Double.parseDouble(upprice.getText());
					suvList.get(i).setPrice(price);
					
					String drivetrain = Drive;
					suvList.get(i).setDrivetrain(drivetrain);

					int year = Integer.parseInt(upyear.getText());
					suvList.get(i).setYear(year);

					String nation = (upnation.getText());
					suvList.get(i).setNation(nation);
					//i++ to search through the array
					}
				}
			} else { //if invalid ID is entered
				 //confirm this to user
			}
		}
		}
		
		catch (IndexOutOfBoundsException e) {
			JOptionPane
			.showMessageDialog(null,
					"You have entered an invalid SUV ID. Please enter a valid ID.", "Cannot find ID", 0);
		}

		catch (NumberFormatException e) {
			JOptionPane
			.showMessageDialog(
					null,
					"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid ID.", "Invalid Entry",0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data Input Error" + e
					+ "\nPlease Try Again", "General Error", 0);

		}
	}	
	else
		{
		JOptionPane.showMessageDialog(null,"I'm sorry, you do not have admin rights..", "Not an Admin", 0);
		}
		fileHandlerS.writeToFile(suvList);

	}
//---------------------------------------------------------------------------------------------------------------------
	// picks random car from the list.
	public void menuRandomCar() {
		Collections.shuffle(carList);
		JOptionPane.showMessageDialog(null,"Your random car is:" + carList.get(0));
	}
// shows the newest car
	public void menuCarNew() {

		JOptionPane.showMessageDialog(null, "This is the newest car" + Collections.max(carList,
	    		new YearComparator()));
	}
// showsthe oldest car
	public void menuCarOld() {
		JOptionPane.showMessageDialog(null, "This is the oldest car" + Collections.min(carList,
	    		new YearComparator()));		
	}
// shows the highest priced car
	public void menuCarPriceHigh() {
		JOptionPane.showMessageDialog(null, "This is the most expensive car" + Collections.max(carList,
	    		new PriceComparator()));				
	}
// shows the lowest priced car.
	public void menuCarPriceLow() {
		JOptionPane.showMessageDialog(null, "This is the least expensive car" + Collections.min(carList,
	    		new PriceComparator()));		
	}

	
	// shows the most powerful car
	public void menuCarBhpHigh() {
		JOptionPane.showMessageDialog(null, "This is the most powerful car" + Collections.max(carList,
	    		new BHPComparator()));			
	}

	// shows the least powerful car.
	public void menuCarBhpLow() {
		JOptionPane.showMessageDialog(null, "This is the least powerful car" + Collections.min(carList,
	    		new BHPComparator()));			
	}
	// random
	public void menuRandomBike() {
		Collections.shuffle(bikeList);
		JOptionPane.showMessageDialog(null,"Your random motorbike is:" + bikeList.get(0));
	}

	
	// new bike
	public void menuBikeNew() {

		JOptionPane.showMessageDialog(null, "This is the newest motorbike" + Collections.max(bikeList,
	    		new YearComparator()));
	}

	public void menuBikeOld() {
		JOptionPane.showMessageDialog(null, "This is the oldest motorbike" + Collections.min(bikeList,
	    		new YearComparator()));		
	}

	public void menuBikePriceHigh() {
		JOptionPane.showMessageDialog(null, "This is the most expensive motorbike" + Collections.max(bikeList,
	    		new PriceComparator()));				
	}

	public void menuBikePriceLow() {
		JOptionPane.showMessageDialog(null, "This is the least expensive motorbike" + Collections.min(bikeList,
	    		new PriceComparator()));		
	}

	public void menuBikeBhpHigh() {
		JOptionPane.showMessageDialog(null, "This is the most powerful motorbike" + Collections.max(bikeList,
	    		new BHPComparator()));			
	}

	public void menuBikeBhpLow() {
		JOptionPane.showMessageDialog(null, "This is the least powerful motorbike" + Collections.min(bikeList,
	    		new BHPComparator()));			
	}
	
	public  void menuRandomSUV() {
		Collections.shuffle(suvList);
		JOptionPane.showMessageDialog(null,"Your random SUV is:" + suvList.get(0));
	}

	public void menuSUVNew() {

		JOptionPane.showMessageDialog(null, "This is the newest SUV" + Collections.max(suvList,
	    		new YearComparator()));
	}

	public void menuSUVOld() {
		JOptionPane.showMessageDialog(null, "This is the oldest SUV" + Collections.min(suvList,
	    		new YearComparator()));		
	}

	public void menuSUVPriceHigh() {
		JOptionPane.showMessageDialog(null, "This is the most expensive SUV" + Collections.max(suvList,
	    		new PriceComparator()));				
	}

	public void menuSUVPriceLow() {
		JOptionPane.showMessageDialog(null, "This is the least expensive SUV" + Collections.min(suvList,
	    		new PriceComparator()));		
	}

	public void menuSUVBhpHigh() {
		JOptionPane.showMessageDialog(null, "This is the most powerful SUV" + Collections.max(suvList,
	    		new BHPComparator()));			
	}

	public void menuSUVBhpLow() {
		JOptionPane.showMessageDialog(null, "This is the least powerful SUV" + Collections.min(suvList,
	    		new BHPComparator()));			
	}
//-------------------------------------------------------------------------------------------------------------------------------
	public void menuSortBHPByLowest()
	{
		 Collections.sort(carList, new BHPComparator());
		 Collections.sort(bikeList, new BHPComparator());
		 Collections.sort(suvList, new BHPComparator());
		 JOptionPane.showMessageDialog(null, carList);
		 JOptionPane.showMessageDialog(null, bikeList);
		 JOptionPane.showMessageDialog(null, suvList); 

	}
	
	public void menuRandomiseList()
	{
		 Collections.shuffle(carList);
		 Collections.shuffle(bikeList);
		 Collections.shuffle(suvList);
		 JOptionPane.showMessageDialog(null, carList);
		 JOptionPane.showMessageDialog(null, bikeList);
		 JOptionPane.showMessageDialog(null, suvList); 

	}
	
	public void menuSortBHPByHighest()
	{
		Collections.sort(carList,
	    		Collections.reverseOrder(new BHPComparator()));
		Collections.sort(bikeList,
	    		Collections.reverseOrder(new BHPComparator()));
		Collections.sort(suvList,
	    		Collections.reverseOrder(new BHPComparator()));
		 JOptionPane.showMessageDialog(null, carList);
		 JOptionPane.showMessageDialog(null, bikeList);
		 JOptionPane.showMessageDialog(null, suvList);	 
	}
	
	public void menuSortPriceByLowest()
	{
		 Collections.sort(carList, new PriceComparator());
		 Collections.sort(bikeList, new PriceComparator());
		 Collections.sort(suvList, new PriceComparator());
		 JOptionPane.showMessageDialog(null, carList);
		 JOptionPane.showMessageDialog(null, bikeList);
		 JOptionPane.showMessageDialog(null, suvList); 
		
	}
	
	public void menuSortPriceByHighest()
	{
		Collections.sort(carList,
	    		Collections.reverseOrder(new PriceComparator()));
		Collections.sort(bikeList,
	    		Collections.reverseOrder(new PriceComparator()));
		Collections.sort(suvList,
	    		Collections.reverseOrder(new PriceComparator()));
		 JOptionPane.showMessageDialog(null, carList);
		 JOptionPane.showMessageDialog(null, bikeList);
		 JOptionPane.showMessageDialog(null, suvList);
	}
	
	public void menuSortYearByLowest()
	{
		 Collections.sort(carList, new YearComparator());
		 Collections.sort(bikeList, new YearComparator());
		 Collections.sort(suvList, new YearComparator());
		 JOptionPane.showMessageDialog(null, carList);
		 JOptionPane.showMessageDialog(null, bikeList);
		 JOptionPane.showMessageDialog(null, suvList); 
		

	}
	
	public void menuSortYearByHighest()
	{

    	Collections.sort(carList,
    		Collections.reverseOrder(new YearComparator()));
    	Collections.sort(bikeList,
        		Collections.reverseOrder(new YearComparator()));
    	Collections.sort(suvList,
        		Collections.reverseOrder(new YearComparator()));
		 JOptionPane.showMessageDialog(null, carList);
		 JOptionPane.showMessageDialog(null, bikeList);
		 JOptionPane.showMessageDialog(null, suvList);
	}
	
	public void menuSortMakeAtoZ()
	{
		Collections.sort(carList,new MakeComparator());
		Collections.sort(bikeList,new MakeComparator());
		Collections.sort(suvList,new MakeComparator());
		 JOptionPane.showMessageDialog(null, carList);
		 JOptionPane.showMessageDialog(null, bikeList);
		 JOptionPane.showMessageDialog(null, suvList);
	}
	
	public void menuSortMakeZtoA()
	{
		Collections.sort(carList,
	    		Collections.reverseOrder(new MakeComparator()));
		Collections.sort(bikeList,
	    		Collections.reverseOrder(new MakeComparator()));
		Collections.sort(suvList,
	    		Collections.reverseOrder(new MakeComparator()));
		 JOptionPane.showMessageDialog(null, carList);
		 JOptionPane.showMessageDialog(null, bikeList);
		 JOptionPane.showMessageDialog(null, suvList);	
	}
	
	public void menuSortModelAtoZ()
	{
		Collections.sort(carList,new ModelComparator());
		Collections.sort(bikeList,new ModelComparator());
		Collections.sort(suvList,new ModelComparator());
		 JOptionPane.showMessageDialog(null, carList);
		 JOptionPane.showMessageDialog(null, bikeList);
		 JOptionPane.showMessageDialog(null, suvList);
	}
	
	public void menuSortModelZtoA()
	{
		Collections.sort(carList,
	    		Collections.reverseOrder(new ModelComparator()));
		Collections.sort(bikeList,
	    		Collections.reverseOrder(new ModelComparator()));
		Collections.sort(suvList,
	    		Collections.reverseOrder(new ModelComparator()));
		 JOptionPane.showMessageDialog(null, carList);
		 JOptionPane.showMessageDialog(null, bikeList);
		 JOptionPane.showMessageDialog(null, suvList);
	}	
//--------------------------------------------------------------------------------------------------------------------------------	 
		public void JargonHelp()
		{
			String cho1 = new String("\nWelcome to our Jargon Helper \nHere we will attempt to guide you through the jargon in this program.\n\nBHP stands for brake horsepower:\nThis is the amount of power that the vehicle has.\n\nSUV stands for Sports Utility Vehicle:\nThese are cars commonly referred to as Jeeps or 4x4s and are made for offroad.\n\n Engine CC in motorbikes is the size of the engine:\n It often means more power for the bikes due to bigger engine size.\n\nThe SUV drivetrain is how many wheels the power of SUV goes to:\nThey are 4 wheel drive, rear wheel drive and front wheel drive.\n4 wheel drive is best for SUVs.\n\nAre wondering about the admin code?:\nOnly an administrator has access to these sections as they contain sensitive data\n\nThe ID's are used to uniquely identify each Car, Motorbike and SUV with ease.\n\nIf you have any more issues plese contact us:\nEmail:20063614@wit.ie\nPhone 085-001010345");

			Object message[] = new Object[2];//create object of message with a max size of 9 items

			message[0]=jargonIcon;
			message[1]=cho1;
			
			int response = JOptionPane.showConfirmDialog(null, message,
					"Modern Classics Museum Showcase", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, blankIcon); 

			if (response == JOptionPane.CANCEL_OPTION); //If cancel is selected then no code is executed				;

		}
		public void menuSearchMake() {
			{
	String searchthemake = (String) JOptionPane.showInputDialog(null, "Please enter the make you wish to search for:", "Make Search", 0,searchIcon, null, "Enter Make of Vehicle Here"); //declare boolean is false
				int z=0;
	int zz=0;
	int zzz=0;
	JOptionPane.showMessageDialog(null,"You will be returned to main menu if you enter incorrect Make");
		try
		{
	while (z < carList.size()) {
		 boolean make = carList.get(z).getMake().toLowerCase().contains(searchthemake.toLowerCase());
	if (make==true)
	{
	JOptionPane.showMessageDialog(null,carList.get(z));//Show details of the car found						    
	}
	else if(carList.get(z).getMake().contains(searchthemake)==false)
	{

	}

	z++;
	}

	while (zz < bikeList.size()) {
		 boolean make1 = bikeList.get(zz).getMake().toLowerCase().contains(searchthemake.toLowerCase());
		if (make1==true)
		{
		JOptionPane.showMessageDialog(null,bikeList.get(zz));//Show details of the car found						    
		}
		else if(zz>bikeList.size())
		{

		}

		zz++;
	}


	while (zzz < suvList.size()) {
		 boolean make2 = suvList.get(zzz).getMake().toLowerCase().contains(searchthemake.toLowerCase());
		 //toLowerCase().contains(str2.toLowerCase())
		if (make2==true)
		{
		JOptionPane.showMessageDialog(null,suvList.get(zzz));//Show details of the car found						    
		}
		else if(suvList.get(zzz).getMake().contains(searchthemake))
		{

		}

		zzz++;

	}
		}

				catch (NullPointerException  e) {
					JOptionPane
					.showMessageDialog(null,
							"You have entered an invalid Car Make. Please enter a valid Make.", "Invalid Make", 0);
				}

				catch (NumberFormatException e) {
					JOptionPane
					.showMessageDialog(
							null,
							"You have either entered nothing or letters into the input box where a number is expected. Please enter a valid Make.", "Invalid Entry",0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Data Input Error" + e
							+ "\nPlease Try Again", "General Error", 0);

				}
				
			}
			}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}


