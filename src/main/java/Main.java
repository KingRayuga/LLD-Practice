import Decorator.*;


public class Main {
    public static void main(String[] args){
        Notifier emailNotifier = new EmailNotitfier();
        Notifier smsNotifier = new SMSNotifier(emailNotifier);
        Notifier slackNotifier = new SlackNotifier(smsNotifier);

        System.out.println("🔹 Only Email:");
        emailNotifier.sendNotification();

        System.out.println("\n🔹 Email + SMS:");
        smsNotifier.sendNotification();

        System.out.println("\n🔹 Email + SMS + Slack:");
        slackNotifier.sendNotification();
    }
}
