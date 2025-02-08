package Factory;

public class SMS implements Notification{
    @Override
    public void send(String message) {
        System.out.println("sending through the SMS " + message);
    }
}
