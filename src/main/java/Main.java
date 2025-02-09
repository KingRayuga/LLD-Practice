import State.TrafficLightContext;
import Strategy.*;

public class Main {
    public static void main(String[] args){
        TrafficLightContext context = new TrafficLightContext();

        context.changeLight();
        context.changeLight();
        context.changeLight();
    }
}
