package Driver;

import java.awt.Color;
import java.util.HashMap;

import Cars.Car;
import Senses.Vision;
import Weather.WeatherState;
import Speed.Speed;

public class F1Driver extends Driver {
	
	private static int speedModifier = 5;
	private static double crashChance = 0.0001;

	public F1Driver(Car _vehicle, Vision _sight) {
		super(_vehicle, _sight);
		this.vehicle.setColor(Color.blue);
	}
	
	public static void weatherSpeedUpdate() {
		if (WeatherState.getState() == "SUNNY") {
			speedModifier = 5;
			crashChance = 0.0005;
		}
		if (WeatherState.getState() == "RAINY") {
			speedModifier = (int)Speed.F1Speed(1);
			crashChance = 0.007;
		}
		if (WeatherState.getState() == "SNOWY") {
			speedModifier = (int)Speed.F1Speed(0);
			crashChance = 0.009;
		}
	}

	public void drive() {
		int currentLaneNo = this.vehicle.getCurrentLaneID();
		HashMap<Integer, Integer> roadInfo = this.sight.getRoadInformation(currentLaneNo, this.vehicle.getCurrentCellID(), this.vehicle.getID());
		int currentLaneStatus = roadInfo.get(currentLaneNo);
		double rand = Math.random();
		
		if(currentLaneStatus > 80 || currentLaneStatus == -100 || crashChance == 1) {
			if(rand < crashChance && crashChance != 1) {
				crashChance = 1;
			}
			this.vehicle.accelerate(speedModifier);
		}
		else if(roadInfo.size() > 1) {
			
			boolean rightClear = false;
			boolean leftClear = false;
			
			if(currentLaneNo != 0 && roadInfo.get(currentLaneNo-1) == -100) {
				rightClear = true;
			} 
			
			if(currentLaneNo != (roadInfo.size()-1) && roadInfo.get(currentLaneNo+1) == -100) {
				leftClear = true;
			}
			
			if(rightClear && leftClear) {
				if(rand < 0.5) {
					this.vehicle.changeLane(currentLaneNo-1);
				}
				else {
					this.vehicle.changeLane(currentLaneNo+1);
				}
					
			}
			else if(rightClear) {
				this.vehicle.changeLane(currentLaneNo-1);
			}
			else if(leftClear) {
				this.vehicle.changeLane(currentLaneNo+1);
			}
		}
	}
}
