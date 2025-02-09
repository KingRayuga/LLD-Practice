package Decorator;

public class EmailNotitfier implements Notifier{
    @Override
    public void sendNotification() {
        System.out.println("Sending notification through Email");
    }
}
