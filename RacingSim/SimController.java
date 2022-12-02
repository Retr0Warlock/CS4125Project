package RacingSim;

import Driver.*;
import Road.Road;
import Road.SimpleRoadFactory;
import Senses.Vision;

import java.awt.*;
import java.util.ArrayList;

import Cars.SimpleCarFactory;
import Cars.Car;

public class SimController extends Controller {

    private ArrayList<Driver> drivers;
    private int numLanes;
    private double screen_width, screen_height;
    private Point center;
    private Controller graphics_manager; 
    private Road road;
    private Controller collisionController;
    private Vision sight;

    public SimController(SimpleControllerFactory c_fac) {
    	SimpleDriverFactory d_fac = new SimpleDriverFactory();
    	SimpleCarFactory v_fac = new SimpleCarFactory();
    	SimpleRoadFactory r_fac = new SimpleRoadFactory();
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	this.drivers = new ArrayList<>();
    	this.screen_width = screenSize.getWidth() / 2;
    	this.screen_height = screenSize.getHeight() / 2;
    	this.numLanes = 3; // max 30
    	this.center = new Point((int)(this.screen_width), (int)(this.screen_height));
    	this.road = r_fac.createRoad(this.numLanes, this.center, screen_width, screen_height);
    	this.sight = new Vision(this.road);
    	
    	addDriversToRoad(d_fac, v_fac);

    	this.collisionController = c_fac.createCollisionDetectionController(drivers);
    	this.graphics_manager = c_fac.createGraphicsController(this.screen_width, this.screen_height, this.drivers, this.road);
    }

    private void addDriversToRoad(SimpleDriverFactory d_fac, SimpleCarFactory v_fac) {
    	int count = 12;
    	for (int i = 0; i < count; i++) {
    		Driver d = null;
    		Car vehicle = null;
    		int start_loc = (1000 / count) * i;
    		switch (i % 4) {
    		case 0:
    			vehicle = v_fac.createVehicle(new Point(0,0), start_loc, this.road, this.road.getRandomLane(), this.numLanes, i, "Average-car.png");
    			d = d_fac.createDriver(SimpleDriverFactory.DriverType.NORMAL, vehicle, this.sight);
    			break;
			case 1:
    			vehicle = v_fac.createVehicle(new Point(0,0), start_loc, this.road, this.road.getRandomLane(), this.numLanes, i, "Fast-car.png");
    			d = d_fac.createDriver(SimpleDriverFactory.DriverType.FAST, vehicle, this.sight);
    			break;
			case 2:
    			vehicle = v_fac.createVehicle(new Point(0,0), start_loc, this.road, this.road.getRandomLane(), this.numLanes, i, "Slow-car.png");
    			d = d_fac.createDriver(SimpleDriverFactory.DriverType.SLOW, vehicle, this.sight);
    			break;
			case 3:
    			vehicle = v_fac.createVehicle(new Point(0,0), start_loc, this.road, this.road.getRandomLane(), this.numLanes, i, "F1-car.png");
    			d = d_fac.createDriver(SimpleDriverFactory.DriverType.F1, vehicle, this.sight);
    			break;
			default:
				vehicle = v_fac.createVehicle(new Point(0,0), start_loc, this.road, this.road.getRandomLane(), this.numLanes, i, "Average-car.png");
				d = d_fac.createDriver(SimpleDriverFactory.DriverType.NORMAL, vehicle, this.sight);
				break;
    		}
    		drivers.add(d);
			
    	}
    }
    
    public void begin() {
    	// Start the drivers driving
    	for (Driver d : drivers) {
    		new Thread(d).start();
    	}
    	
    	new Thread(collisionController).start();
    	// Start showing them on screen
    	graphics_manager.run();
    }
}
