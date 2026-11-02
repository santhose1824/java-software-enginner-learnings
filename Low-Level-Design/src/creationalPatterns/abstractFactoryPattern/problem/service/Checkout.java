package creationalPatterns.abstractFactoryPattern.problem.service;

import creationalPatterns.abstractFactoryPattern.problem.factory.CheckoutFactory;
import creationalPatterns.abstractFactoryPattern.problem.interfaces.Invoice;
import creationalPatterns.abstractFactoryPattern.problem.interfaces.PaymentGateway;

public class Checkout {
    public void checkout(String type){
        PaymentGateway paymentGateway = CheckoutFactory.createPaymentGateway(type);
        paymentGateway.paymentProcess();

        Invoice invoice = CheckoutFactory.createInvoice();
        invoice.invoiceGenerate();
    }
}
