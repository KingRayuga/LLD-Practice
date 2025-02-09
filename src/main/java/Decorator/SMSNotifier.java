package Decorator;

public class SMSNotifier extends NotifierDecorator{
    public SMSNotifier(Notifier notifier){
        super(notifier);
    }

    @Override
    public void sendNotification() {
        System.out.println("sending message through SMS");
        super.sendNotification();
    }
}
