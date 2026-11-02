package creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.concreteClasses.us;

import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.PaymentGateway;

public class PayPal implements PaymentGateway {
    @Override
    public void paymentProcess() {
        System.out.println("US PayPal is generated.");
    }
}
