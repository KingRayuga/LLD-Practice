package Bridge;

public abstract class Remote {
    protected Device device;
    public Remote(Device device){
        this.device = device;
    }
    public abstract void turnOn();
    public abstract void turnOff();
}
