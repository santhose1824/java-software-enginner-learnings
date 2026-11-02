package strcturedPatterns.adapterPattern.adapterPatternExample.adapter;

import strcturedPatterns.adapterPattern.adapterPatternExample.api.RazorPayApi;
import strcturedPatterns.adapterPattern.adapterPatternExample.interfaces.PaymentGateway;

public class RazorPayAdapter implements PaymentGateway {
    private RazorPayApi api;
    public RazorPayAdapter() {
        this.api = new RazorPayApi();
    }

    @Override
    public void pay(String orderId, double amount) {
        api.makePayment(orderId, amount);
    }
}
