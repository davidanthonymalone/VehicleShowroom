package dm_ds.wit.vehicleshowroom;

import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class VehicleSubMenus {
	Date date = new Date();
	VehicleMuseumAL museum = new VehicleMuseumAL();
	private ImageIcon vehicleIcon = new ImageIcon(getClass().getResource("/HeadingLogo.png"));
	private ImageIcon carIcon = new ImageIcon(getClass().getResource("/CarLogo.png"));
	private ImageIcon bikeIcon = new ImageIcon(getClass().getResource("/BikeLogo.png"));
	private ImageIcon suvIcon = new ImageIcon(getClass().getResource("/SUVLogo.png"));
		private static Icon blankIcon = new ImageIcon(); //Blank image icon
		

		public int SubMenuAdd()
		{
		int choose = 0; 
		String cho1 = new String("1. Add a Car:");
		String cho2 = new String("2. Add a Motorbike:");
		String cho3 = new String("3. Add a SUV:");
		String cho4 = new String("4. Go Back:");
		String msg = new String("Enter Option:");
		JTextField cho = new JTextField(""); //allows user to enter option in GUI

		Object message[] = new Object[8];//create object of message with a max size of 9 items

		message[0] = vehicleIcon;
		message[1] = cho1;
		message[2] = cho2;
		message[3] = cho3;
		message[4] = cho4;
		message[5] = msg;
		message[6] = cho;
		message[7] = date.toString();


		int response = JOptionPane.showConfirmDialog(null, message,
				"Modern Classics Museum Showcase", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, blankIcon); 

		if (response == JOptionPane.CANCEL_OPTION) //If cancel is selected then no code is executed
			;
		else {//If option is selected will either give an error if 1-6 is not selected or will execute desired option
			try { //Program will try and run this code
				
				choose = Integer.parseInt(cho.getText());
				

				switch(choose)
				{
				case 1: museum.menuAddCar();
					break;
				case 2: museum.menuAddBike();
					break;
				case 3: museum.menuAddSUV();
					break;
				case 4: break;
					default : JOptionPane.showMessageDialog(null, "You have not entered options 1-4, please enter one of these options.");
					break;
				}
			
			}
			
			catch (NumberFormatException e) { //if there is any problems with the code in the try block then the catches will stop program from crashing
				JOptionPane
				.showMessageDialog(
						null,
						"You have not entered any options into the menu or have entered an invalid character. Please enter an option."); //showMessageDialog will show this text in the GUI instead of text box
			}
				

			catch (Exception e) { //General Exception
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again");
			}
		}

		return choose; //Return the value entered
	}
	
	
	public int SubMenuShow()
	{
		int choose = 0; 
		String cho1 = new String("1. Search for a Car:");
		String cho2 = new String("2. Search for a Motorbike:");
		String cho3 = new String("3. Search for a SUV:");
		String cho4 = new String("4. Search by Make:");
		String cho5 = new String("5. Search by Model:");
		String cho6 = new String("6. Search by Nationality:");
		String cho7 = new String("7. Go Back:");
		String msg = new String("Enter Option:");
		JTextField cho = new JTextField(""); //allows user to enter option in GUI

		Object message[] = new Object[11];//create object of message with a max size of 9 items

		message[0] = vehicleIcon;
		message[1] = cho1;
		message[2] = cho2;
		message[3] = cho3;
		message[4] = cho4;
		message[5] = cho5;
		message[6] = cho6;
		message[7] = cho7;
		message[8] = msg;
		message[9] = cho;
		message[10] = date.toString();


		int response = JOptionPane.showConfirmDialog(null, message,
				"Modern Classics Museum Showcase", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, blankIcon); 

		if (response == JOptionPane.CANCEL_OPTION) //If cancel is selected then no code is executed
			;
		else {//If option is selected will either give an error if 1-6 is not selected or will execute desired option
			try { //Program will try and run this code
				
				choose = Integer.parseInt(cho.getText());
				

				switch(choose)
				{
				case 1: museum.menuShowCar();
					break;
				case 2: museum.menuShowBike();
					break;
				case 3: museum.menuShowSUV();
					break;
				case 4: museum.menuSearchMake();
				break;
				case 5: museum.menuSearchModel();
				break;
				case 6: museum.menuSearchNation();
					break;
				case 7: break;
					default : JOptionPane.showMessageDialog(null, "You have not entered options 1-7, please enter one of these options.");
					break;
				}
			
			}
			
			catch (NumberFormatException e) { //if there is any problems with the code in the try block then the catches will stop program from crashing
				JOptionPane
				.showMessageDialog(
						null,
						"You have not entered any options into the menu or have entered an invalid character. Please enter an option."); //showMessageDialog will show this text in the GUI instead of text box
			}
				

			catch (Exception e) { //General Exception
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again");
			}
		}

		return choose; //Return the value entered
	}
	
	public int SubMenuList()
	{
		int choose = 0; 
		String cho1 = new String("1. List all Vehicles:");
		String cho2 = new String("2. List all cars");
		String cho3 = new String("3. List all Motorbike:");
		String cho4 = new String("4. List all SUV:");
		String cho5 = new String("5. Go Back:");
		String msg = new String("Enter Option:");
		JTextField cho = new JTextField(""); //allows user to enter option in GUI

		Object message[] = new Object[9];//create object of message with a max size of 9 items

		message[0] = vehicleIcon;
		message[1] = cho1;
		message[2] = cho2;
		message[3] = cho3;
		message[4] = cho4;
		message[5] = cho5;
		message[6] = msg;
		message[7] = cho;
		message[8] = date.toString();


		int response = JOptionPane.showConfirmDialog(null, message,
				"Modern Classics Museum Showcase", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, blankIcon); 

		if (response == JOptionPane.CANCEL_OPTION) //If cancel is selected then no code is executed
			;
		else {//If option is selected will either give an error if 1-6 is not selected or will execute desired option
			try { //Program will try and run this code
				
				choose = Integer.parseInt(cho.getText());
				

				switch(choose)
				{
				case 1: museum.menuListVehicle();
					break;
				case 2: museum.menuListCar();
					break;
				case 3: museum.menuListBike();
					break;
				case 4: museum.menuListSUV();
					break;
				case 5: break;
					default : JOptionPane.showMessageDialog(null, "You have not entered options 1-5, please enter one of these options.");
					break;
				}
			
			}
			
			catch (NumberFormatException e) { //if there is any problems with the code in the try block then the catches will stop program from crashing
				JOptionPane
				.showMessageDialog(
						null,
						"You have not entered any options into the menu or have entered an invalid character. Please enter an option."); //showMessageDialog will show this text in the GUI instead of text box
			}
				

			catch (Exception e) { //General Exception
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again");
			}
		}

		return choose; //Return the value entered
	}
	
	public int SubMenuUpdate()
	{
		int choose = 0; 
		String cho1 = new String("1. Update a Car:");
		String cho2 = new String("2. Update a Motorbike:");
		String cho3 = new String("3. Update a SUV:");
		String cho4 = new String("4. Go Back:");
		String msg = new String("Enter Option:");
		JTextField cho = new JTextField(""); //allows user to enter option in GUI

		Object message[] = new Object[8];//create object of message with a max size of 9 items

		message[0] = vehicleIcon;
		message[1] = cho1;
		message[2] = cho2;
		message[3] = cho3;
		message[4] = cho4;
		message[5] = msg;
		message[6] = cho;
		message[7] = date.toString();


		int response = JOptionPane.showConfirmDialog(null, message,
				"Modern Classics Museum Showcase", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, blankIcon); 

		if (response == JOptionPane.CANCEL_OPTION) //If cancel is selected then no code is executed
			;
		else {//If option is selected will either give an error if 1-6 is not selected or will execute desired option
			try { //Program will try and run this code
				
				choose = Integer.parseInt(cho.getText());
				

				switch(choose)
				{
				case 1: museum.menuUpdateCar();
					break;
				case 2: museum.menuUpdateBike();
					break;
				case 3: museum.menuUpdateSUV();
					break;
				case 4:
					break;
					default : JOptionPane.showMessageDialog(null, "You have not entered options 1-4, please enter one of these options.");
					break;
				}
			
			}
			
			catch (NumberFormatException e) { //if there is any problems with the code in the try block then the catches will stop program from crashing
				JOptionPane
				.showMessageDialog(
						null,
						"You have not entered any options into the menu or have entered an invalid character. Please enter an option."); //showMessageDialog will show this text in the GUI instead of text box
			}
				

			catch (Exception e) { //General Exception
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again");
			}
		}

		return choose; //Return the value entered
	}
	
	
	
	public int SubMenuRemove()
	{
		int choose = 0; 
		String cho1 = new String("1. Remove a Car:");
		String cho2 = new String("2. Remove a Motorbike:");
		String cho3 = new String("3. Remove a SUV:");
		String cho4 = new String("4. Go Back:");
		String msg = new String("Enter Option:");
		JTextField cho = new JTextField(""); //allows user to enter option in GUI

		Object message[] = new Object[8];//create object of message with a max size of 9 items

		message[0] = vehicleIcon;
		message[1] = cho1;
		message[2] = cho2;
		message[3] = cho3;
		message[4] = cho4;
		message[5] = msg;
		message[6] = cho;
		message[7] = date.toString();


		int response = JOptionPane.showConfirmDialog(null, message,
				"Modern Classics Museum Showcase", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, blankIcon); 

		if (response == JOptionPane.CANCEL_OPTION) //If cancel is selected then no code is executed
			;
		else {//If option is selected will either give an error if 1-6 is not selected or will execute desired option
			try { //Program will try and run this code
				
				choose = Integer.parseInt(cho.getText());
				

				switch(choose)
				{
				case 1: museum.menuRemoveCar();
					break;
				case 2: museum.menuRemoveBike();
					break;
				case 3: museum.menuRemoveSUV();
					break;
				case 4:
					break;
					default : JOptionPane.showMessageDialog(null, "You have not entered options 1-4, please enter one of these options.");
					break;
				}
			
			}
			
			catch (NumberFormatException e) { //if there is any problems with the code in the try block then the catches will stop program from crashing
				JOptionPane
				.showMessageDialog(
						null,
						"You have not entered any options into the menu or have entered an invalid character. Please enter an option."); //showMessageDialog will show this text in the GUI instead of text box
			}
				

			catch (Exception e) { //General Exception
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again");
			}
		}

		return choose; //Return the value entered
	}

	
	public int SubMenuSort()
	{
		int choose = 0; 
		String cho1 = new String("1. Sort by BHP from lowest to highest:");
		String cho2 = new String("2. Sort by BHP from highest to lowest:");
		String cho3 = new String("3. Sort by Price from lowest to highest:");
		String cho4 = new String("4. Sort by Price from highest to lowest:");
		String cho5 = new String("5. Sort by Year from lowest to highest:");
		String cho6 = new String("6. Sort by Year from highest to lowest:");
		String cho7 = new String("7. Sort by Make from lowest to  highest:");
		String cho8 = new String("8. Sort by Make from highest to lowest:");
		String cho9 = new String("9. Sort by Model from lowest to highest:");
		String cho10 = new String("10. Sort by Model from highest to lowest:");
		String cho11 = new String ("11. Randomise the lists: ");
		String cho12 = new String ("12. Go back: ");
		String msg = new String("Enter Option:");
		JTextField cho = new JTextField(""); //allows user to enter option in GUI

		Object message[] = new Object[16];//create object of message with a max size of 9 items

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
		message[10] = cho10;
		message[11] = cho11;
		message[12] = cho12;
		message[13] = msg;
		message[14] = cho;
		message[15] = date.toString();


		int response = JOptionPane.showConfirmDialog(null, message,
				"Modern Classics Museum Showcase", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, blankIcon); 

		if (response == JOptionPane.CANCEL_OPTION) //If cancel is selected then no code is executed
			;
		else {//If option is selected will either give an error if 1-6 is not selected or will execute desired option
			try { //Program will try and run this code
				
				choose = Integer.parseInt(cho.getText());
				

				switch(choose)
				{
				case 1: museum.menuSortBHPByLowest();
					break;
				case 2: museum.menuSortBHPByHighest();
					break;
				case 3: museum.menuSortPriceByLowest();
					break;
				case 4: museum.menuSortPriceByHighest();
					break;
				 case 5: museum.menuSortYearByLowest();
				 break;
				 case 6: museum.menuSortYearByHighest();
				 break;
				 case 7: museum.menuSortMakeAtoZ();
				 break;
				 case 8: museum.menuSortMakeZtoA();
				 break;
				 case 9: museum.menuSortModelAtoZ();
				 break;
				 case 10: museum.menuSortModelZtoA();
				 break;
				 case 11: museum.menuRandomiseList();
					 break;
				 case 12: 
					 break;
					default : JOptionPane.showMessageDialog(null, "You have not entered options 1-12, please enter one of these options.");
					break;
				}
			
			}
			
			catch (NumberFormatException e) { //if there is any problems with the code in the try block then the catches will stop program from crashing
				JOptionPane
				.showMessageDialog(
						null,
						"You have not entered any options into the menu or have entered an invalid character. Please enter an option."); //showMessageDialog will show this text in the GUI instead of text box
			}
				

			catch (Exception e) { //General Exception
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again");
			}
		}

		return choose; //Return the value entered
	}
	
	public int SubMenuSearch()
	{
		int choose = 0; 
		String cho1 = new String("1. Search for aspects of Car:");
		String cho2 = new String("2. Search for aspects of Bike:");
		String cho3 = new String("3. Search for aspects of SUV:");
		String cho4 = new String("4. Go Back:");
		String msg = new String("Enter Option:");
		JTextField cho = new JTextField(""); //allows user to enter option in GUI

		Object message[] = new Object[8];//create object of message with a max size of 9 items

		message[0] = vehicleIcon;
		message[1] = cho1;
		message[2] = cho2;
		message[3] = cho3;
		message[4] = cho4;
		message[5] = msg;
		message[6] = cho;
		message[7] = date.toString();


		int response = JOptionPane.showConfirmDialog(null, message,
				"Modern Classics Museum Showcase", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, blankIcon); 

		if (response == JOptionPane.CANCEL_OPTION) //If cancel is selected then no code is executed
			;
		else {//If option is selected will either give an error if 1-6 is not selected or will execute desired option
			try { //Program will try and run this code
				
				choose = Integer.parseInt(cho.getText());
				

				switch(choose)
				{
				case 1: SubMenuCarSearch();
					break;
				case 2: SubMenuBikeSearch();
					break;
				case 3: SubMenuSUVSearch();
					break;
				case 4: break;
					default : JOptionPane.showMessageDialog(null, "You have not entered options 1-4, please enter one of these options.");
					break;
				}
			
			}
			
			catch (NumberFormatException e) { //if there is any problems with the code in the try block then the catches will stop program from crashing
				JOptionPane
				.showMessageDialog(
						null,
						"You have not entered any options into the menu or have entered an invalid character. Please enter an option."); //showMessageDialog will show this text in the GUI instead of text box
			}
				

			catch (Exception e) { //General Exception
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again");
			}
		}

		return choose; //Return the value entered
	}
	
	public void SubMenuBikeSearch()
	{
		int choose = 0; 
		String cho1 = new String("1. Find motorbike with least BHP:");
		String cho2 = new String("2. Find motorbike with most BHP:");
		String cho3 = new String("3. Find cheapest motorbike:");
		String cho4 = new String("4. Find most expensive motorbike:");
		String cho5 = new String("5. Find oldest motorbike:");
		String cho6 = new String("6. Find newest motorbike:");
		String cho7 = new String("7. Get a random motorbike");
		String cho8 = new String("8. Go Back:");
		String msg = new String("Enter Option:");
		JTextField cho = new JTextField(""); //allows user to enter option in GUI

		Object message[] = new Object[12];//create object of message with a max size of 9 items

		message[0] = bikeIcon;
		message[1] = cho1;
		message[2] = cho2;
		message[3] = cho3;
		message[4] = cho4;
		message[5] = cho5;
		message[6] = cho6;
		message[7] = cho7;
		message[8] = cho8;
		message[9] = msg;
		message[10] = cho;
		message[11] = date.toString();


		int response = JOptionPane.showConfirmDialog(null, message,
				"Modern Classics Museum Showcase", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, blankIcon); 

		if (response == JOptionPane.CANCEL_OPTION) //If cancel is selected then no code is executed
			;
		else {//If option is selected will either give an error if 1-6 is not selected or will execute desired option
			try { //Program will try and run this code
				
				choose = Integer.parseInt(cho.getText());
				

				switch(choose)
				{
				case 1: museum.menuBikeBhpLow();
					break;
				case 2: museum.menuBikeBhpHigh();
					break;
				case 3: museum.menuBikePriceLow();
					break;
				case 4: museum.menuBikePriceHigh();
				break;
				case 5: museum.menuBikeOld();
				break;
				case 6: museum.menuBikeNew();
				break;
				case 7: museum.menuRandomBike();
					break;
				case 8: 
					break;
					default : JOptionPane.showMessageDialog(null, "You have not entered options 1-8, please enter one of these options.");
					break;
				}
			
			}
		
			

catch (NumberFormatException e) { //if there is any problems with the code in the try block then the catches will stop program from crashing
JOptionPane
.showMessageDialog(
		null,
		"You have not entered any options into the menu or have entered an invalid character. Please enter an option."); //showMessageDialog will show this text in the GUI instead of text box
}


catch (Exception e) { //General Exception
JOptionPane.showMessageDialog(null, "Data Input Error" + e
		+ "\nPlease Try Again");
}
}
	}
	
	public void SubMenuSUVSearch()
	{
		int choose = 0; 
		String cho1 = new String("1. Find SUV with least BHP:");
		String cho2 = new String("2. Find SUV with most BHP:");
		String cho3 = new String("3. Find cheapest SUV:");
		String cho4 = new String("4. Find most expensive SUV:");
		String cho5 = new String("5. Find oldest SUV:");
		String cho6 = new String("6. Find newest SUV:");
		String cho7 = new String("7. Get a random SUV:");
		String cho8 = new String("8. Go Back:");
		String msg = new String("Enter Option:");
		JTextField cho = new JTextField(""); //allows user to enter option in GUI

		Object message[] = new Object[12];//create object of message with a max size of 9 items

		message[0] = suvIcon;
		message[1] = cho1;
		message[2] = cho2;
		message[3] = cho3;
		message[4] = cho4;
		message[5] = cho5;
		message[6] = cho6;
		message[7] = cho7;
		message[8] = cho8;
		message[9] = msg;
		message[10] = cho;
		message[11] = date.toString();


		int response = JOptionPane.showConfirmDialog(null, message,
				"Modern Classics Museum Showcase", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, blankIcon); 

		if (response == JOptionPane.CANCEL_OPTION) //If cancel is selected then no code is executed
			;
		else {//If option is selected will either give an error if 1-6 is not selected or will execute desired option
			try { //Program will try and run this code
				
				choose = Integer.parseInt(cho.getText());
				

				switch(choose)
				{
				case 1: museum.menuSUVBhpLow();
					break;
				case 2: museum.menuSUVBhpHigh();
					break;
				case 3: museum.menuSUVPriceLow();
					break;
				case 4: museum.menuSUVPriceHigh();
				break;
				case 5: museum.menuSUVOld();
				break;
				case 6: museum.menuSUVNew();
				break;
				case 7: museum.menuRandomSUV();
					break;
				case 8: 
					break;
					default : JOptionPane.showMessageDialog(null, "You have not entered options 1-8, please enter one of these options.");
					break;
				}
			
			}
			

catch (NumberFormatException e) { //if there is any problems with the code in the try block then the catches will stop program from crashing
JOptionPane
.showMessageDialog(
		null,
		"You have not entered any options into the menu or have entered an invalid character. Please enter an option."); //showMessageDialog will show this text in the GUI instead of text box
}


catch (Exception e) { //General Exception
JOptionPane.showMessageDialog(null, "Data Input Error" + e
		+ "\nPlease Try Again");
}
}
	}
						
		
					public int SubMenuCarSearch()
					{
						int choose = 0; 
						String cho1 = new String("1. Find car with least BHP:");
						String cho2 = new String("2. Find car with most BHP:");
						String cho3 = new String("3. Find cheapest car:");
						String cho4 = new String("4. Find most expensive car:");
						String cho5 = new String("5. Find oldest car:");
						String cho6 = new String("6. Find newest car:");
						String cho7 = new String("7. Get a random car:");
						String cho8 = new String("8. Go Back:");
						String msg = new String("Enter Option:");
						JTextField cho = new JTextField(""); //allows user to enter option in GUI

						Object message[] = new Object[12];//create object of message with a max size of 9 items

						message[0] = carIcon;
						message[1] = cho1;
						message[2] = cho2;
						message[3] = cho3;
						message[4] = cho4;
						message[5] = cho5;
						message[6] = cho6;
						message[7] = cho7;
						message[8] = cho8;
						message[9] = msg;
						message[10] = cho;
						message[11] = date.toString();


						int response = JOptionPane.showConfirmDialog(null, message,
								"Modern Classics Museum Showcase", JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, blankIcon); 

						if (response == JOptionPane.CANCEL_OPTION) //If cancel is selected then no code is executed
							;
						else {//If option is selected will either give an error if 1-6 is not selected or will execute desired option
							try { //Program will try and run this code
								
								choose = Integer.parseInt(cho.getText());
								

								switch(choose)
								{
								case 1: museum.menuCarBhpLow();
									break;
								case 2: museum.menuCarBhpHigh();
									break;
								case 3: museum.menuCarPriceLow();
									break;
								case 4: museum.menuCarPriceHigh();
								break;
								case 5: museum.menuCarOld();
								break;
								case 6: museum.menuCarNew();
								break;
								case 7: museum.menuRandomCar();
									break;
								case 8: 
									break;
									default : JOptionPane.showMessageDialog(null, "You have not entered options 1-8, please enter one of these options.");
									break;
								}
							
							}
							
			
			catch (NumberFormatException e) { //if there is any problems with the code in the try block then the catches will stop program from crashing
				JOptionPane
				.showMessageDialog(
						null,
						"You have not entered any options into the menu or have entered an invalid character. Please enter an option."); //showMessageDialog will show this text in the GUI instead of text box
			}
				

			catch (Exception e) { //General Exception
				JOptionPane.showMessageDialog(null, "Data Input Error" + e
						+ "\nPlease Try Again");
			}
		}

		return choose; //Return the value entered
	}

}
