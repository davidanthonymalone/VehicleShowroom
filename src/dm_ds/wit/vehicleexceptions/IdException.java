package dm_ds.wit.vehicleexceptions;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class IdException extends Exception {
	public IdException() {
		super("This is not a valid id");
		JOptionPane.showMessageDialog(null,"Please enter a valid ID", "Thank you",0);
	}

	
}