package strcturedPatterns.adapterPattern.problem.interfaces;

public interface PaymentGateway {
    void pay(String orderId, double amount);
}
