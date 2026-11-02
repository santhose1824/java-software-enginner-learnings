package strcturedPatterns.facadePattern.facadePatternExample;

import strcturedPatterns.facadePattern.facadePatternExample.facade.BookingFacade;

/*
     What we are doing is move all the process inside one class and create method to call all the methods for the process,
     So that the client will just enter their process not care about how they are process.
*/

public class Main {
    public static void main(String[] args) {
        BookingFacade  facade = new BookingFacade();
        facade.bookTicket("user123","movie123","santhose18@gmail.com","H12",50,450.00);
    }
}
