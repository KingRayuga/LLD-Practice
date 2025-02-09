package Bridge;

public class BasicRemote extends Remote{
    public BasicRemote(Device device){
        super(device);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on using basic remote..");
        device.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off using basic remote..");
        device.turnOff();
    }
}
