package State;

public class RedLight implements TrafficLightState{

    @Override
    public void handleRequest(TrafficLightContext trafficLightContext) {
        System.out.println("Red Light to Green Light");
        trafficLightContext.setState(new GreenLight());
    }
}
