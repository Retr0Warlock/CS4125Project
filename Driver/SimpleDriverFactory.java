package Driver;

import Cars.Car;
import Senses.Vision;

public class SimpleDriverFactory {
	
	public static enum DriverType {
		NORMAL,
		FAST,
		SLOW,
		F1
	};
	
	public Driver createDriver(DriverType type, Car _vehicle, Vision _sight){
		
		// This method should never return NULL
		switch(type) {
	    case NORMAL: 
			return new AverageDriver(_vehicle, _sight);
		case FAST: 
			return new FastDriver(_vehicle, _sight);
		case SLOW: 
			return new SlowDriver(_vehicle, _sight);
		case F1: 
			return new F1Driver(_vehicle, _sight);
		default:
			return new AverageDriver(_vehicle, _sight);
		}
	}
	
}
