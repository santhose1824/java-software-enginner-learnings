package behaviourPatterns.templatePattern.problem;

public class EmailNotification {
    public void send(String to, String message){
        System.out.println("Checking the rate limits for : "+to);
        System.out.println("Validating email recipient : "+to);
        String formatted = message.trim();

        System.out.println("Logging before send : "+formatted+" to : "+to);

        String composedMessage = "<html><body><p>" + formatted + "</p></body></html>";

        System.out.println("Sending email to : "+to+" with content : "+composedMessage);

        System.out.println("Analytics updated for : "+to);
    }
}
