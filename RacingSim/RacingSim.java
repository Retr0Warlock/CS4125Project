package RacingSim;

import Driver.AverageDriver;
import Weather.WeatherState;

public class RacingSim extends Controller {

    public static void main(String[] args) {
    	WeatherState.setState();
        AverageDriver.weatherSpeedUpdate();
        
        SimpleControllerFactory factory = new SimpleControllerFactory();

        Controller sc = factory.createSimulationController(factory);

        sc.begin();
    }
    
}
