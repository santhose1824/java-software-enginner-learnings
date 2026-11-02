package creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.service;

import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.CountryFactory;
import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.Invoice;
import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.PaymentGateway;

public class CheckoutService {
    private PaymentGateway paymentGateway;
    private Invoice invoice;
    private String type;
    public CheckoutService(CountryFactory countryFactory,String type){
        this.type = type;
        this.paymentGateway = countryFactory.createPaymentGateway(type);
        this.invoice = countryFactory.crateInvoice();
    }

    public void completePayment(){
        paymentGateway.paymentProcess();
        invoice.invoiceGenerate();
    }
}
