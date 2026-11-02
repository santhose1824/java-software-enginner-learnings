package strcturedPatterns.adapterPattern.adapterPatternExample;

import strcturedPatterns.adapterPattern.adapterPatternExample.adapter.RazorPayAdapter;
import strcturedPatterns.adapterPattern.adapterPatternExample.concreteClass.PayU;
import strcturedPatterns.adapterPattern.adapterPatternExample.service.CheckoutService;


/*
    Structural Pattern - Focuses on how class and objects structured to form larger components.
    What is the problem here everything is fine right?
    The problem comes when we move to other third party.

    So what Adapter pattern tells is had an adapter class and make it to implements the interface and made the class to adapt it.
    What I am doing is create a class called adapter class and implements then make it to use the interface method.
*/

public class Main {
    public static void main(String[] args) {
        // This is for PayU
        CheckoutService checkoutService = new CheckoutService(new PayU());
        checkoutService.checkout("ID1837Xhd480",104875.80);

        // This is for Razorpay
        CheckoutService checkoutService2 = new CheckoutService(new RazorPayAdapter());
        checkoutService2.checkout("ID1837Xhd480",104875.80);
    }
}
