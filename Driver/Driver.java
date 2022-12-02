package Driver;

import Cars.Car;
import Senses.Vision;
import Threading.Timer;
import Weather.Observer_WeatherState;
import Weather.WeatherState;

public class Driver implements Runnable, Observer_WeatherState {

	protected Vision sight;
	protected Car vehicle;
	protected double speedModifier;
	


	public Driver(Car _vehicle, Vision _sight) {
		this.sight = _sight;
		this.vehicle =_vehicle;
	}
	
	public Car getVehicle() {
		return this.vehicle;
	}
	
	public Vision getSight() {
		return this.sight;
	}

	public void stop() {
		
	}

	public void drive() {
		
	}

	public void run() {
		Timer t = new Timer(Timer.DEFAULT_FRAMERATE);
    	t.setMessage("Driver");
		while(true) {
			t.start();
			this.drive();
			t.end();
		}
	}

	public void update(Object obj) {
		if (obj instanceof WeatherState) {
			WeatherState ws = (WeatherState) obj;
			if (ws.getState() == "SUNNY") {
				
			}
			if (ws.getState() == "RAINY") {
				speedModifier = speedModifier * 0.75;
			}
			if (ws.getState() == "SNOWY") {
				speedModifier = speedModifier * 0.5;
			}
		}
	}
}
