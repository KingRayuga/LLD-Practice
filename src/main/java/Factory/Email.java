package Factory;

public class Email implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Sending through the Email " + message);
    }
}
