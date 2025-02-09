package State;

public class GreenLight implements TrafficLightState{

    @Override
    public void handleRequest(TrafficLightContext trafficLightContext) {
        System.out.println("Green Light to Yellow Light");
        trafficLightContext.setState(new YellowLight());
    }
}
