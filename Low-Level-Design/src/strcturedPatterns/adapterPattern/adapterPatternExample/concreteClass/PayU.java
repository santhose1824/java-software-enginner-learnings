package strcturedPatterns.adapterPattern.adapterPatternExample.concreteClass;

import strcturedPatterns.adapterPattern.adapterPatternExample.interfaces.PaymentGateway;

public class PayU implements PaymentGateway {
    @Override
    public void pay(String orderId, double amount) {
        System.out.println("PayU received orderId: " + orderId + ", amount: " + amount);
    }
}
