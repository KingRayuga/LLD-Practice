import Bridge.*;


public class Main {
    public static void main(String[] args){
        Device tv = new TV();
        Device radio = new Radio();

        Remote basicRemote = new BasicRemote(tv);
        Remote advancedRemote = new AdvancedRemote(radio);

        basicRemote.turnOn();
        basicRemote.turnOff();

        advancedRemote.turnOn();
        advancedRemote.turnOff();
    }
}
