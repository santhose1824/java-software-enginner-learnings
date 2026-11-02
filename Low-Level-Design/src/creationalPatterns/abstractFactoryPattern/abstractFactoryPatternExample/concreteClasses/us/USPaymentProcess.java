package creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.concreteClasses.us;

import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.CountryFactory;
import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.Invoice;
import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.PaymentGateway;

public class USPaymentProcess implements CountryFactory {
    @Override
    public PaymentGateway createPaymentGateway(String type) {
        switch (type.toLowerCase()) {
            case "strpie" -> {return new Stripe();}
            case "paypal" -> {return new PayPal();}
            default -> {throw new IllegalArgumentException("Unsupported PaymentGateway type in UsPaymentProcess");}
        }
    }

    @Override
    public Invoice crateInvoice() {
        return new USInvoice();
    }
}
