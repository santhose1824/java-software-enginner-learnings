package strcturedPatterns.facadePattern.problem.ticketBookingProcess;

public class LoyaltyPoints {
    private String accountId;
    private int points;

    public LoyaltyPoints(String accountId, int points) {
        this.accountId = accountId;
        this.points += points;
    }

    public void addPoints() {

        System.out.println("Adding points for account " + accountId + " with amount " + points);
    }
}
