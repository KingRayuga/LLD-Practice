package Decorator;

public class SlackNotifier extends NotifierDecorator{

    public SlackNotifier(Notifier notifier){
        super(notifier);
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending through slack");
        super.sendNotification();
    }
}
