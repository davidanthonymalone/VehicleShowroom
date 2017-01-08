package dm_ds.wit.vehicleexceptions;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class CustomException extends Exception {
	public CustomException() {
		super("You need to enter between options 1 and 9");
		JOptionPane.showMessageDialog(null,
				"You have to enter an option between 1 and 9", "Invalid Command Entry",0);
	}

	
}