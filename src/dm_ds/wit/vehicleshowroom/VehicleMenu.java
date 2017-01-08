package dm_ds.wit.vehicleshowroom;



import javax.swing.JOptionPane; //Importing JOptionPane util from java library

import dm_ds.wit.vehicleexceptions.CustomException;
import dm_ds.wit.vehicleshowroom.VehicleMuseumAL;

public class VehicleMenu { //Class where the menu selections are directed

	public static void main(String args[])
	{
		int choose; 

		VehicleMuseumAL museum = new VehicleMuseumAL();
		VehicleSubMenus sub = new VehicleSubMenus();
		choose = museum.menuMain(); 
		do { 
			
			
			
			
			choose = museum.menuMain(); 
			try
	        {
	            if( choose > 9)
	            {
	            	// My custom exception presents an error and displays a message if the user enters a number over 6. 
	                 throw new CustomException();
	            }
	        }
	        catch(CustomException e )
	        {
	            
	        }

			switch(choose)//Switch statement is used to determine which option is inputed by user
			{
			case 1 : sub.SubMenuAdd(); //When option 1 is selected in GUI it calls the add car method in class CarMuseumAL
			break;
			case 2 : sub.SubMenuShow();//When option 2 is selected in GUI it calls the show car method in class CarMuseumAL
			break;
			case 3 : sub.SubMenuList();
			break; 
			case 4 : sub.SubMenuRemove();
			break;
			case 5 : sub.SubMenuUpdate();
			break;
			case 6: sub.SubMenuSearch();
			break;
			case 7: sub.SubMenuSort();
			break;
			case 8: museum.JargonHelp();
			break;
			case 9: 
			break;
			default : //JOptionPane.showMessageDialog(null, "You have not entered options 1-9, please enter one of these options."); //When options 1-6 is not entered this message is displayed to user
			break;
			}
		} while(choose != 9); //While option 6 is not selected the code will loop
	}

}


