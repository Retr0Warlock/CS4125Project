package RacingSim;

import java.util.ArrayList;

import Driver.Driver;
import Road.Road;
import Threading.Timer;
import UIManager.Display;
import UIManager.DrawingComponent;
import UIManager.IDisplay;

public class GraphicsController extends Controller {

    private String title;
    private double screenWidth, screenHeight;
    public DrawingComponent draw;

    //private Thread thread;
    private IDisplay display;

    public GraphicsController(double screenWidth, double screenHeight, ArrayList<Driver> drivers, Road road) {
        this.title = "Racing Simulation";
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.initDisplay();
        this.draw = new DrawingComponent(this.display, screenWidth, screenHeight, road, drivers);
    }

    @Override
    public void run() {
    	Timer t = new Timer(Timer.DEFAULT_FRAMERATE);
    	t.setMessage("Graphics Controller");
        while(true) {
        	t.start();
        	draw.render();
        	t.end();
        }
    }

    public void initDisplay() {
        display = new Display(title, screenWidth, screenHeight);
        display.createDisplay();
    }
}



