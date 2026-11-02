package creationalPatterns.abstractFactoryPattern.problem;

/*
    Consider we have the Payment Service in our application, only for India for process the payment and generate invoice.
    India generally has 2 most used payment gateways razor-pay and pay-u.
    So If I want to implement this in my application I definitely go with the Factory Pattern and implement it.
    But the problem :
    When  I want to add another country by creating another factory class and do it, this will violate the Factory
    Pattern which follows SRP and OCP.
    So if we are using more than one factory class then it is automatically not comes under the factory pattern.
*/

import creationalPatterns.abstractFactoryPattern.problem.service.Checkout;

public class Main {
    public static void main(String[] args) {

        //PayU Payment has been invoked
        //GST invoice is generated for India.
        Checkout checkout = new Checkout();
        checkout.checkout("razor");
    }
}
