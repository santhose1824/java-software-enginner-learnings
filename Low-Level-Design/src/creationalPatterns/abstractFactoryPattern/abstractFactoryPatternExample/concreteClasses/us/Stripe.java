package creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.concreteClasses.us;

import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.PaymentGateway;

public class Stripe implements PaymentGateway {
    @Override
    public void paymentProcess() {
        System.out.println("Stripe is generated.");
    }
}
