package Bridge;

public class AdvancedRemote extends Remote{
    public AdvancedRemote(Device device){
        super(device);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on using advanced remote..");
        device.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off using advanced remote..");
        device.turnOff();
    }
}
