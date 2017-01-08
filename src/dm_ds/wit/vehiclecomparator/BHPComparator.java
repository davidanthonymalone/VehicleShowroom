package dm_ds.wit.vehiclecomparator;

import java.util.Comparator;

import dm_ds.wit.vehicle.Vehicle;

public class BHPComparator implements Comparator<Vehicle>
{

	

	@Override
	public int compare(Vehicle vehbhp1, Vehicle vehbhp2) {
		return vehbhp1.getBhp() - vehbhp2.getBhp();
	
	}
}