package strcturedPatterns.facadePattern.problem.ticketBookingProcess;

public class Payment {
    private String accountId;
    private double amount;

    public Payment(String accountId, double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public void makePayment() {
        System.out.println("Payment for account " + accountId + " with amount " + amount);
    }
}
