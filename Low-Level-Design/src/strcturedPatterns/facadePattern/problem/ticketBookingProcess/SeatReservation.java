package strcturedPatterns.facadePattern.problem.ticketBookingProcess;

public class SeatReservation {
    private String movieId;
    private String seatNumber;

    public  SeatReservation(String movieId, String seatNumber) {
        this.movieId = movieId;
        this.seatNumber = seatNumber;
    }

    public void reserveSeat() {
        System.out.println("Reserving seat " + seatNumber);
    }
}
