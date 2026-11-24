package behaviourPatterns.templatePattern.templatePatternExample.concreteClasses;

import behaviourPatterns.templatePattern.templatePatternExample.template.NotificationSender;

public class EmailNotification extends NotificationSender {

    @Override
    protected String composedMessage(String message) {
        return "<html><body><p>" + message  + "</p></body></html>";
    }

    @Override
    protected void sendMessage(String to, String composedMessage) {
        System.out.println("Sending email to : "+to+" with the content: "+composedMessage);
    }

}
