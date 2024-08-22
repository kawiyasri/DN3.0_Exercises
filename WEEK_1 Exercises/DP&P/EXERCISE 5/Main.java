// TestDecoratorPattern.java
public class TestDecoratorPattern {
    public static void main(String[] args) {
        // Create a base notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate with SMS notifier
        Notifier smsEmailNotifier = new SMSNotifierDecorator(emailNotifier);

        // Further decorate with Slack notifier
        Notifier slackSmsEmailNotifier = new SlackNotifierDecorator(smsEmailNotifier);

        // Send a notification
        slackSmsEmailNotifier.send("Hello World!");
    }
}
