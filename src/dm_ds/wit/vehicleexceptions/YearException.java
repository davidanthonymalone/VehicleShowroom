package dm_ds.wit.vehicleexceptions;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class YearException extends Exception {
public YearException() {
		super("\nThis is a Classic car showroom please enter between 1800-1995");
		
	}
}