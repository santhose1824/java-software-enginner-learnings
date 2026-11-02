package creationalPatterns.abstractFactoryPattern.problem.factory;

import creationalPatterns.abstractFactoryPattern.problem.concreteClasses.GST;
import creationalPatterns.abstractFactoryPattern.problem.concreteClasses.PayU;
import creationalPatterns.abstractFactoryPattern.problem.concreteClasses.RazorPay;
import creationalPatterns.abstractFactoryPattern.problem.interfaces.Invoice;
import creationalPatterns.abstractFactoryPattern.problem.interfaces.PaymentGateway;

public class CheckoutFactory {
    public static PaymentGateway createPaymentGateway(String type) {
        if(type.equalsIgnoreCase("razor")) {
            return new RazorPay();
        }
        return new PayU();
    }

    public static Invoice  createInvoice() {
        return new GST();
    }
}
