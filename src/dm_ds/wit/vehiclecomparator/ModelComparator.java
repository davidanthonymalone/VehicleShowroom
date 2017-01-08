package dm_ds.wit.vehiclecomparator;

import java.util.Comparator;

import dm_ds.wit.vehicle.Vehicle;

public class ModelComparator implements Comparator<Vehicle>
{

	@Override
	public int compare(Vehicle vehmod1, Vehicle vehmod2) {
	      String model1 = vehmod1.getModel().toUpperCase();
	      String model2 = vehmod2.getModel().toUpperCase();	
	      return model1.compareTo(model2);
	}

}



