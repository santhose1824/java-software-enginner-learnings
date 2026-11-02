package creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample;

/*
    Here I am going to implement the Abstract Factory Pattern.
    What it is means instead of creating a Factory class I am going to create a Factory interface.
    Here what I was doing is just create interface that holds the PaymentGateway and the Invoice interface.

    So the problem we face is we can't able to create so many Factory classes.
    Instead of that I create factory interface that can be able to implements via many classes.

    So if I want to create a new checkout service for US means I just need to create a classes for it and use it .
    By this I am not touching the Checkout service a bit,so that the SRP and OCP are followed.

    While extended the Payment Process for different countries we are not modified the CheckoutService.

*/

import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.concreteClasses.indian.IndianPaymentProcess;
import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.concreteClasses.us.USPaymentProcess;
import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.service.CheckoutService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Indian Payment Service");
        CheckoutService indianCheckoutService = new CheckoutService(new IndianPaymentProcess(),"payU");
        indianCheckoutService.completePayment();


        System.out.println("US Payment Service");
        CheckoutService usCheckoutService = new CheckoutService(new USPaymentProcess(),"paypal");
        usCheckoutService.completePayment();

        /*
            Indian Payment Service
            PayU Payment has been invoked
            GST invoice is generated for India.
            US Payment Service
            US PayPal is generated.
            US invoice is generated.
        */
    }
}
