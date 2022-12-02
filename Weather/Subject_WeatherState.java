package Weather;

public interface Subject_WeatherState {
    void Attach(Observer_WeatherState o);
    void Dettach(Observer_WeatherState o);
    void Notify();
}
