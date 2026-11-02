package strcturedPatterns.facadePattern.facadePatternExample.ticketBookingProcess;

public class Notification {

    public void sendBookingConfirmation(String emailId) {
        System.out.println("Sending confirmation for email " + emailId);
    }
}
