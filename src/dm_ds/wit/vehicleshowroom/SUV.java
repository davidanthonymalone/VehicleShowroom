package dm_ds.wit.vehicleshowroom;
import dm_ds.wit.vehicle.Vehicle;





@SuppressWarnings("serial")
public class SUV extends Vehicle { // Car Museum Constructor Class

	private int SUVId = 0; // When variable is called puts generated car IDs up by one
	private String drivetrain;
	


	public SUV(int SUVId, String make, String model, int bhp, int year, String nation,double price, String drivetrain, int response) 
	{
	super(make,model,bhp,year,nation,price);
	this.SUVId = SUVId;
	this.drivetrain = drivetrain;
	}


	public int getSUVId() {
		return SUVId;
	}



	public void setSUVId(int sUVId) {
		SUVId = sUVId;
	}


	public String getDrivetrain() {
		return drivetrain;
	}



	public void setDrivetrain(String drivetrain) {
		this.drivetrain = drivetrain;
	}



	@Override
	public String toString() { // toString prints out details to the user when called
		return "\n-SUV ID: " + SUVId + ", SUV Make: " + make + ", SUV Model: "
		+ model + ", SUV BHP: " + bhp + ", SUV Cost: "
		+ price + ", SUV Year: " + year
		+ ", SUV Nationality: " + nation + ", SUV Drivetrain: " + drivetrain;
	}




	
	
}