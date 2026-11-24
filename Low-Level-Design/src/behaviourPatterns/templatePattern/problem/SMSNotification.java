package behaviourPatterns.templatePattern.problem;

public class SMSNotification {
    public void send(String to, String message){
        System.out.println("Checking the rate limits for : "+to);
        System.out.println("Validating phone number : "+to);
        String formatted = message.trim();

        System.out.println("Logging before send : "+formatted+" to : "+to);

        String composedMessage = "[SMS]" + formatted;

        System.out.println("Sending SMS to : "+to+" with content : "+composedMessage);

        System.out.println("Custom SMS Analytics updated for : "+to);
    }
}
