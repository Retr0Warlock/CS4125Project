package Weather;

import java.util.ArrayList;

public class WeatherState implements Subject_WeatherState {
    public static String state;
    private static int min = 1;
    private static int max = 3;
    public static int randomNum = (int)Math.floor(Math.random()*(max-min+1)+min);
    private ArrayList<Observer_WeatherState> observers;
    
    public static String setState() {
        if (randomNum == 1) {
            state = "SUNNY";
        }
        if (randomNum == 2) {
            state = "RAINY";
        }
        if (randomNum == 3) {
            state = "SNOWY";
        }

        return state;
        
    }
    
    public static String getState() {
        return state;
    }

    public void Attach(Observer_WeatherState o) {
        observers.add(o);
    }

    public void Dettach(Observer_WeatherState o) {
        observers.remove(o);
    }

    public void Notify() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this);
        }
    }
}
