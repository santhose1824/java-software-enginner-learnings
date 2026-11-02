package creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.concreteClasses.indian;

import creationalPatterns.abstractFactoryPattern.abstractFactoryPatternExample.interfaces.Invoice;

public class GST implements Invoice {
    @Override
    public void invoiceGenerate() {
        System.out.println("GST invoice is generated for India.");
    }

}
