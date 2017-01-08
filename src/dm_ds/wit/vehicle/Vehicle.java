package dm_ds.wit.vehicle;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Vehicle implements Serializable 
{

	protected String make;
	protected String model;
	protected int bhp;
	protected int year;
	protected String nation;
	protected double price;


	public Vehicle(String make, String model, int bhp, int year, String nation,	double price) {
		this.make = make;
		this.model = model;
		this.bhp = bhp;
		this.year = year;
		this.nation = nation;
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getBhp() {
		return bhp;
	}

	public void setBhp(int bhp) {
		this.bhp = bhp;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	
}
