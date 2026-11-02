package creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.concreteClasses.us;

import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.Invoice;

public class USInvoice implements Invoice {
    @Override
    public void invoiceGenerate() {
        System.out.println("US invoice is generated.");
    }
}
