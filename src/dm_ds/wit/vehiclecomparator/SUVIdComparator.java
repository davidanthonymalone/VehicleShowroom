package dm_ds.wit.vehiclecomparator;

import java.util.Comparator;

import dm_ds.wit.vehicleshowroom.SUV;

public class SUVIdComparator implements Comparator<SUV>
{

	@Override
	public int compare(SUV suvid1, SUV suvid2) {
		return (int) (suvid1.getSUVId() - suvid2.getSUVId());
	
	}
}