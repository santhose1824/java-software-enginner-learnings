package strcturedPatterns.facadePattern.problem;

import strcturedPatterns.facadePattern.problem.ticketBookingProcess.*;

/*
    Now we are try to make an entertainment ticket booking app.
    So If I consider for booking ticket for movies means this is how I want to deal it .
    But the app doesn't only have the movies, they have standup comedies, Music concert etc.
    So if I fo the all services like this in the client side this is not meant to be a good application.
    So this is the problem that solved by Facade Pattern.
*/

public class Main {
    public static void main(String[] args) {
        Payment  payment   = new Payment("user123",450.00);
        payment.makePayment();

        SeatReservation seatReservation = new SeatReservation("movie123","H12");
        seatReservation.reserveSeat();

        Notification notification = new Notification();
        notification.sendBookingConfirmation("santosemaha18@gmail.com");

        LoyaltyPoints loyaltyPoints = new LoyaltyPoints("user123",100);
        loyaltyPoints.addPoints();

        TicketBooking ticketBooking = new TicketBooking("movie123","H12");
        ticketBooking.generateTicket();

    }
}
