package strcturedPatterns.facadePattern.facadePatternExample.ticketBookingProcess;

public class Payment {


    public void makePayment(String accountId, double amount) {
        System.out.println("Payment for account " + accountId + " with amount " + amount);
    }
}
