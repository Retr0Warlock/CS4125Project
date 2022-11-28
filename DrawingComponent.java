package UIManager;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import Road.*;
import Driver.Driver;

import javax.imageio.ImageIO;

import Cars.Car;
import Weather.WeatherState;

public class DrawingComponent implements IDrawingComponent {

    private int screenWidth;
    private int screenHeight;
    private BufferStrategy buffer;
    private ArrayList<Driver> drivers;
    private BufferedImage grass;
    private IDisplay display;
    private Graphics2D graphics;
    private ArrayList<Lane> lanes;
    private String GRASS_IMAGE_PATH;


    public DrawingComponent(IDisplay _display, double screenWidth, double screenHeight, Road road, ArrayList<Driver> drivers) {
        this.screenWidth = (int) screenWidth;
        this.screenHeight = (int) screenHeight;
        this.lanes = road.getLanes();
        this.drivers = drivers;
        if (WeatherState.state == "SUNNY") {
            this.GRASS_IMAGE_PATH = "grass.png";
        }
        if (WeatherState.state == "RAINY") {
            this.GRASS_IMAGE_PATH = "grass-rain.png";
        }
        if (WeatherState.state == "SNOWY") {
            this.GRASS_IMAGE_PATH = "grass-snow.png";
        }
        this.display = _display;
        this.grass = this.createGrass();
        this.createGraphics();
    }
    
    private void createGraphics() {
    	this.display.getCanvas().createBufferStrategy(3);
        this.buffer = display.getCanvas().getBufferStrategy();
        this.graphics = (Graphics2D) buffer.getDrawGraphics();
    	this.graphics.clearRect(0, 0, screenWidth, screenHeight);
    }

    public void render() {

        this.drawGrass();

        for (Lane l : this.lanes) {
            this.drawLane(l);
        }

    	for (Driver d : this.drivers) {
            this.drawVehicle(d.getVehicle());
    	}
    	
    	this.buffer.show();
    }
    
    private BufferedImage createGrass() {
    	try {
            return ImageIO.read(new File(GRASS_IMAGE_PATH));
        } catch (Exception e) {
            return null;
        }
    }
    
    private void drawGrass() {
    	this.graphics.drawImage(this.grass, 0, 0, null);
    }

    private void drawLane(Lane lane) {
        this.graphics.setColor(lane.getLaneColor());
        this.graphics.setStroke(new BasicStroke(lane.getLaneWidth()));
        this.graphics.draw(new Ellipse2D.Double(lane.getX(), lane.getY(), lane.getWidth(), lane.getHeight()));
        this.graphics.setColor(new Color(255, 255, 255));
        this.graphics.setStroke(new BasicStroke(lane.getLaneWidth()/20));
        this.graphics.draw(new Ellipse2D.Double(lane.getX() - lane.getLaneWidth()/2, lane.getY() - lane.getLaneWidth()/2, lane.getWidth() + lane.getLaneWidth(), lane.getHeight() + lane.getLaneWidth()));
        this.graphics.draw(new Ellipse2D.Double(lane.getX() + lane.getLaneWidth()/2, lane.getY() + lane.getLaneWidth()/2, lane.getWidth() - lane.getLaneWidth(), lane.getHeight() - lane.getLaneWidth()));
    }

    private void drawVehicle(Car v) {
        Point pos = v.getPosition();
        Point p2 = new Point(pos.x - (v.getVehicleWidth() / 2), pos.y - (v.getVehicleHeight() / 2));

        AffineTransform at = new AffineTransform();
        at.rotate(v.getAngle(), p2.x + (v.getVehicleWidth() / 2), p2.y + (v.getVehicleHeight() / 2));
        at.translate(p2.x + (v.getVehicleWidth() / 8), p2.y + (v.getVehicleWidth() / 4));

        this.graphics.drawImage(v.getCarImage(), at, null);
    }
}
