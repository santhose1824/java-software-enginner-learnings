package strcturedPatterns.facadePattern.problem.ticketBookingProcess;

public class Notification {

    public void sendBookingConfirmation(String emailId) {
        System.out.println("Sending confirmation for email " + emailId);
    }
}
