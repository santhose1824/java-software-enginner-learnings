package behaviourPatterns.templatePattern.templatePatternExample;


/*
    This will helps us to create an template and force the developer to use that template flow,
    By this we can maintain the scalability and easy to implement.
*/

import behaviourPatterns.templatePattern.templatePatternExample.concreteClasses.EmailNotification;
import behaviourPatterns.templatePattern.templatePatternExample.concreteClasses.SMSNotification;
import behaviourPatterns.templatePattern.templatePatternExample.template.NotificationSender;

public class Main {
    public static void main(String[] args) {
        NotificationSender email = new EmailNotification();
        email.send("santhose18@gmail.com","You have the new notification");

        NotificationSender sms = new SMSNotification();
        sms.send("6382158828","You have new notification");
    }
}
