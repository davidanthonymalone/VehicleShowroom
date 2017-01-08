package dm_ds.wit.vehiclecomparator;

import java.util.Comparator;

import dm_ds.wit.vehicle.Vehicle;

public class YearComparator implements Comparator<Vehicle>
{

	

	@Override
	public int compare(Vehicle vehyear1, Vehicle vehyear2) {
		return vehyear1.getYear() - vehyear2.getYear();
	
	}
}