package creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces;

public interface CountryFactory {
    PaymentGateway createPaymentGateway(String type);
    Invoice crateInvoice();
}
