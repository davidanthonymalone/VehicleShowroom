package dm_ds.wit.vehiclecomparator;

import java.util.Comparator;

import dm_ds.wit.vehicle.Vehicle;

public class MakeComparator implements Comparator<Vehicle>
{

	@Override
	public int compare(Vehicle vehmake1, Vehicle vehmake2) {
	      String make1 = vehmake1.getMake().toUpperCase();
	      String make2 = vehmake2.getMake().toUpperCase();	
	      return make1.compareTo(make2);
	}

}
