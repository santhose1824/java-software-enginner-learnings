package strcturedPatterns.adapterPattern.adapterPatternExample.api;

public class RazorPayApi {
    public void makePayment(String invoiceId, double amount){
        System.out.println("Razorpay received orderId: " + invoiceId + ", amount: " + amount);
    }
}
