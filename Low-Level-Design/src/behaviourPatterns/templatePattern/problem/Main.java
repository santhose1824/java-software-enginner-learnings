package behaviourPatterns.templatePattern.problem;

/*
    Consider we have the notifications functionality to send notifications to user on Email as well all platfrom,
    But for everytime I am write the Same method with some changes again and again,
    In future if I had new notification system is then I need to write again from scratch.
    This is solved by Template Method Pattern.
*/

public class Main {
    public static void main(String[] args) {
        EmailNotification email = new EmailNotification();
        email.send("santhosemaha18@gmail.com","You missed the opportunity to get eh reward. Redeem it now");

        SMSNotification sms = new SMSNotification();
        sms.send("6382158828","You missed the opportunity to get eh reward. Redeem it now");
    }
}
