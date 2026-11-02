package strcturedPatterns.adapterPattern.problem.service;

import strcturedPatterns.adapterPattern.problem.interfaces.PaymentGateway;

public class CheckoutService {
    private PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void checkout(String orderId, double amount) {
        paymentGateway.pay(orderId, amount);
    }
}
