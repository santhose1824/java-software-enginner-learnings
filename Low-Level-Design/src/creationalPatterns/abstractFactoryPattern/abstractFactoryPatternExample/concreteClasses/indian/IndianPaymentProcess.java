package creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.concreteClasses.indian;

import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.CountryFactory;
import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.Invoice;
import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.PaymentGateway;

public class IndianPaymentProcess implements CountryFactory {

    @Override
    public PaymentGateway createPaymentGateway(String type) {
        switch (type.toLowerCase()) {
            case "razorpay" ->{ return new RazorPay();}
            case "payu" -> { return new PayU();}
            default -> throw new IllegalArgumentException("Unsupported paymemt type in IndianPaymentProcess");
        }
    }

    @Override
    public Invoice crateInvoice() {
        return new GST();
    }
}
