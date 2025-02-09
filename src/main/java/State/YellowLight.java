package State;

public class YellowLight implements TrafficLightState{

    @Override
    public void handleRequest(TrafficLightContext trafficLightContext) {
        System.out.println("Yellow Light to Red Light");
        trafficLightContext.setState(new RedLight());
    }
}
