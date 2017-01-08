package dm_ds.wit.vehicleshowroom;
import dm_ds.wit.vehicle.Vehicle;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Bike extends Vehicle { // Car Museum Constructor Class

	private int BikeId = 0; // Starting point for car id is 100
	private int enginecc;
	


	public Bike(int BikeId, String make, String model, int bhp, int year, String nation,double price, int enginecc, int response) 
	{
	super(make,model,bhp,year,nation,price);
	this.BikeId = BikeId;
	this.enginecc = enginecc;
	}



	public int getBikeId() {
		return BikeId;
	}



	public void setBikeId(int bikeId) {
		BikeId = bikeId;
	}



	public int getEnginecc() {
		return enginecc;
	}



	public void setEnginecc(int enginecc) {
		this.enginecc = enginecc;
	}



	@Override
	public String toString() { // toString prints out details to the user when called
		return "\n-Motorbike ID: " + BikeId + ", Motorbike Make: " + make + ", Motorbike Model: "
		+ model + ", Motorbike BHP: " + bhp + ", Motorbike Cost: "
		+ price + ", Motorbike Year: " + year
		+ ", Motorbike Nationality: " + nation + ", Motorbike Engine CC: " + enginecc;
	}




}