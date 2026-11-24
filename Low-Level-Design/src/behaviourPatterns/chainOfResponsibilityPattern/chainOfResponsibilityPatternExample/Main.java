package behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample;

import behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample.abstractClasses.SupportHandler;
import behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample.handlers.BillingSupport;
import behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample.handlers.DeliverySupport;
import behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample.handlers.GeneralSupport;
import behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample.handlers.TechnicalSupport;

public class Main {
    public static void main(String[] args) {
        SupportHandler generalSupport = new GeneralSupport();
        SupportHandler billingSupport = new BillingSupport();
        SupportHandler technicalSupport = new TechnicalSupport();
        SupportHandler deliverySupport = new DeliverySupport();

        generalSupport.setNextHandler(billingSupport);
        billingSupport.setNextHandler(technicalSupport);
        technicalSupport.setNextHandler(deliverySupport);


        generalSupport.handleRequest("refund");
        generalSupport.handleRequest("delivery");
        generalSupport.handleRequest("unknown");
    }
}
