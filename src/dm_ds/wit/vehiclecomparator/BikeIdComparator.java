package dm_ds.wit.vehiclecomparator;

import java.util.Comparator;

import dm_ds.wit.vehicleshowroom.Bike;

public class BikeIdComparator implements Comparator<Bike>
{

	@Override
	public int compare(Bike bikeid1, Bike bikeid2) {
		return (int) (bikeid1.getBikeId() - bikeid2.getBikeId());
	
	}
}