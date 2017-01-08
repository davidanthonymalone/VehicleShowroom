package dm_ds.wit.vehicleio;
import dm_ds.wit.vehicle.Vehicle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import javax.swing.JOptionPane;


@SuppressWarnings("unused")
public class FileHandlerCar {
	private FileOutputStream FOS;
	private ObjectOutputStream OOS;
	private FileInputStream FIS;
	private ObjectInputStream OIS;
	private File carFile;
	
	public void setFileCar()
	{
		carFile = new File("Cars.dat");
	}
	
	public boolean isFileEmpty()
	{
		return (carFile.length()<=0);
	}
	
 	public void writeToFile(List<? extends Serializable> team)
	{
	 try
	 {
	  FOS = new FileOutputStream(carFile);
	  OOS = new ObjectOutputStream(FOS);
	 
	  OOS.writeObject(team);
	  
	  FOS.close();
	  OOS.close();
	 }
	 catch(IOException e)
	 {
		 JOptionPane.showMessageDialog(null,"File Handling Error" + e + "\nPlease contact us via the contact information on the jargon page");
	 }
	}
 	
@SuppressWarnings("unchecked")
public List<? extends Serializable> readFromFile(Class<? extends Serializable> currentCarClass)
	
	{
	List<? extends Serializable> tempfile = null;
	
	try
	 {
	  FIS = new FileInputStream(carFile);
	  OIS = new ObjectInputStream(FIS);
	 
	  if(!this.isFileEmpty())
		  tempfile = (List<? extends Serializable>)OIS.readObject();
	  
	  FIS.close();
	  OIS.close();
	 }
	 catch(IOException e)
	 {
		 JOptionPane.showMessageDialog(null,"File Handling Error" + e + "\nPlease contact us via the contact information on the jargon page");

	 }
	 
	 catch(Exception e)
	 {
		 JOptionPane.showMessageDialog(null,"An Error has occured" + e + "\nPlease contact us via the contact information on the jargon page");

	 }

	return tempfile;
	}

}