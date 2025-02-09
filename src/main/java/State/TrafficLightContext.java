package State;

public class TrafficLightContext {
    private TrafficLightState trafficLightState;

    public TrafficLightContext(){
        trafficLightState = new RedLight();
    }

    public void setState(TrafficLightState trafficLightState){
        this.trafficLightState = trafficLightState;
    }

    public void changeLight(){
        trafficLightState.handleRequest(this);
    }
}
