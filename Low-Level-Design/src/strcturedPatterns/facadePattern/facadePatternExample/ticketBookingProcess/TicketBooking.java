package strcturedPatterns.facadePattern.facadePatternExample.ticketBookingProcess;

public class TicketBooking {

    public void generateTicket(String movieId,String seatNumber){
        System.out.println("Ticket is generated for the movie " + movieId +", Seat " + seatNumber);
    }
}
