package creationalPatterns.abstractFactoryPattern.problem.concreteClasses;

import creationalPatterns.abstractFactoryPattern.problem.interfaces.Invoice;

public class GST implements Invoice {
    @Override
    public void invoiceGenerate() {
        System.out.println("GST invoice is generated for India.");
    }

}
