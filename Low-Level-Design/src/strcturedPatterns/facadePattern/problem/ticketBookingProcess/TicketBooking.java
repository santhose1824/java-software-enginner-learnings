package strcturedPatterns.facadePattern.problem.ticketBookingProcess;

public class TicketBooking {
    private String movieId;
    private String seatNumber;

    public TicketBooking(String movieId, String seatNumber) {
        this.movieId = movieId;
        this.seatNumber = seatNumber;
    }

    public void generateTicket(){
        System.out.println("Ticket is generated for the movie " + movieId +", Seat " + seatNumber);
    }
}
