package dm_ds.wit.vehicleshowroom;
import dm_ds.wit.vehicle.Vehicle;



@SuppressWarnings("serial")
public class  Car extends Vehicle { // Car Museum Constructor Class

	private int CarId=0; // When variable is called puts generated car IDs up by one // Starting point for car id is 100
	private int door;
	


	public Car(int CarId, String make, String model, int bhp, int year, String nation,double price, int door, int response) 
	{
	super(make,model,bhp,year,nation,price);
	this.CarId = CarId;
	this.door = door;
	}

	public int getCarId() { // When called returns the car Id
		return CarId;
	}

	public void setCarId(int carId) { // When called it sets a value to car id, no return type
		CarId = carId;
	}

	

	public int getDoor() {
		return door;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	@Override
	public String toString() { // toString prints out details to the user when called
		return "\n-Car ID: " + CarId + ", Car Make: " + make + ", Car Model: "
		+ model + ", Car BHP: " + bhp + ", Car Cost: "
		+ price + ", Car Year: " + year
		+ ", Car Nationality: " + nation + ", Car Doors: " + door + " door";
	}


	
}