package Cars;
import java.awt.Point;

import Road.Road;

public class SimpleCarFactory {
	
	public Car createVehicle(Point xy, int cellId, Road road, int laneId, int numLanes, int id, String imagePath){
		return new Car(xy, cellId, road, laneId, numLanes, id, imagePath);
	}
	
}
