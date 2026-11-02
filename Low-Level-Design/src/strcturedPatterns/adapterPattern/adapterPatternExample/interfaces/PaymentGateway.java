package strcturedPatterns.adapterPattern.adapterPatternExample.interfaces;

public interface PaymentGateway {
    void pay(String orderId, double amount);
}
