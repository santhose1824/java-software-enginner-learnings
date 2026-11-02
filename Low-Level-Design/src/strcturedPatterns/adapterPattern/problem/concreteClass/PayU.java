package strcturedPatterns.adapterPattern.problem.concreteClass;

import strcturedPatterns.adapterPattern.problem.interfaces.PaymentGateway;

public class PayU implements PaymentGateway {
    @Override
    public void pay(String orderId, double amount) {
        System.out.println("PayU received orderId: " + orderId + ", amount: " + amount);
    }
}
