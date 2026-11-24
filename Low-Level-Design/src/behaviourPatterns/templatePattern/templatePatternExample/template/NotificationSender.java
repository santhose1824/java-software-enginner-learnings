package behaviourPatterns.templatePattern.templatePatternExample.template;

public abstract class NotificationSender {
    public void send(String to, String message){
        // same template
        rateLimitCheck(to);
        validateRecipient(to);
        String formatted = formatMessage(message);
        preSendAuditLog(to,formatted);
        // logic
        String composed = composedMessage(message);
        sendMessage(to,composed);
        // template
        postSendAnalytics(to);
    }

    private void rateLimitCheck(String to){
        System.out.println("Checking rate limits for : "+to);
    }

    private void validateRecipient(String to){
        System.out.println("Validating recipient : "+to);
    }

    private String formatMessage(String message){
        return message.trim();
    }

    private void preSendAuditLog(String to, String formattedMessage){
        System.out.println("Logging before send  : "+formattedMessage+" to : "+to);
    }

    // Hooks for subclasses
    protected  abstract String composedMessage(String message);
    protected abstract void sendMessage(String to, String composedMessage);


    protected void postSendAnalytics(String to){
        System.out.println("Analytics updated for : "+to);
    }
}
