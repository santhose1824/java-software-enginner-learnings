package creationalPatterns.abstractFactoryPattern.problem.concreteClasses;

import creationalPatterns.abstractFactoryPattern.problem.interfaces.PaymentGateway;

public class RazorPay implements PaymentGateway {
    @Override
    public void paymentProcess() {
        System.out.println("PayU Payment has been invoked");
    }
}
