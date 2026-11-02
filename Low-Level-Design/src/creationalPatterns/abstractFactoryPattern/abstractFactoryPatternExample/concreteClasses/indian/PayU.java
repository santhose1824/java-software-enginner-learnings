package creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.concreteClasses.indian;

import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.PaymentGateway;

public class PayU implements PaymentGateway {
    @Override
    public void paymentProcess() {
        System.out.println("PayU Payment has been invoked");
    }
}
