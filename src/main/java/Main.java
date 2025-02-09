import Command.*;
import Observer.CurrentConditionsDisplay;
import Observer.StatisticsDisplay;
import Observer.WeatherStation;

public class Main {
    public static void main(String[] args){

        WeatherStation weatherStation = new WeatherStation();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();

        weatherStation.registerObserver(currentDisplay);
        weatherStation.registerObserver(statisticsDisplay);

        weatherStation.setMeasurements(25.0f, 65.0f, 1013.0f);
        weatherStation.setMeasurements(26.5f, 70.0f, 1012.0f);
        weatherStation.setMeasurements(24.0f, 60.0f, 1014.0f);
    }
}
