package dm_ds.wit.vehiclecomparator;

import java.util.Comparator;

import dm_ds.wit.vehicle.Vehicle;

public class PriceComparator implements Comparator<Vehicle>
{

	

	@Override
	public int compare(Vehicle vehprice1, Vehicle vehprice2) {
		return (int) (vehprice1.getPrice() - vehprice2.getPrice());
	
	}
}