import Factory.Notification;
import Factory.NotificationFactory;
import Factory.NotificationType;

public class Main {
    public static void main(String[] args){
        NotificationFactory notificationFactory= new NotificationFactory();
        Notification notification = notificationFactory.getNotificationSystem(NotificationType.EMAIL);
        notification.send("LOL");
    }
}
