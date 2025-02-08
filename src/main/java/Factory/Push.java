package Factory;

public class Push implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Sending through the push notification " + message);
    }
}
