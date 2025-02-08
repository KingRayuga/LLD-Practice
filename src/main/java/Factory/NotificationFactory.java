package Factory;

public class NotificationFactory {
    public Notification getNotificationSystem(NotificationType notificationType){
        return switch (notificationType) {
            case EMAIL -> new Email();
            case PUSH -> new Push();
            case SMS -> new SMS();
        };
    }
}
