package behaviourPatterns.templatePattern.templatePatternExample.concreteClasses;

import behaviourPatterns.templatePattern.templatePatternExample.template.NotificationSender;

public class SMSNotification extends NotificationSender {

    @Override
    protected String composedMessage(String message) {
        return "[SMS]" + message;
    }

    @Override
    protected void sendMessage(String to, String composedMessage) {
        System.out.println("Sending SMS to : "+to+" with the message: "+composedMessage);
    }

    // Override Optional Hooks
    @Override
    protected void postSendAnalytics(String to) {
        System.out.println("Custom SMS analytics to : "+to);
    }
}
