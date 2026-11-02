package strcturedPatterns.facadePattern.facadePatternExample.facade;

import strcturedPatterns.facadePattern.facadePatternExample.ticketBookingProcess.*;

public class BookingFacade {
    Payment payment;
    SeatReservation seatReservation;
    Notification  notification;
    LoyaltyPoints loyaltyPoints;
    TicketBooking ticketBooking;

    public BookingFacade(){
        this.payment = new Payment();
        this.seatReservation = new SeatReservation();
        this.notification = new Notification();
        this.loyaltyPoints = new LoyaltyPoints();
        this.ticketBooking = new TicketBooking();
    }

    public void bookTicket(String accountId,String movieId, String emailId, String seatNumber, int points, double amount){
        payment.makePayment(accountId,amount);
        seatReservation.reserveSeat(seatNumber);
        notification.sendBookingConfirmation(emailId);
        loyaltyPoints.addPoints(accountId,points);
        ticketBooking.generateTicket(movieId,seatNumber);

        System.out.println("Ticket Booked Successfully");
    }
}
