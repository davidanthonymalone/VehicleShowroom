package dm_ds.wit.vehiclecomparator;

import java.util.Comparator;

import dm_ds.wit.vehicleshowroom.Car;

public class CarIdComparator implements Comparator<Car>
{

	@Override
	public int compare(Car carid1, Car carid2) {
		return (int) (carid1.getCarId() - carid2.getCarId());
	
	}
}