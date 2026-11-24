package behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample.handlers;

import behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample.abstractClasses.SupportHandler;

public class BillingSupport extends SupportHandler {
    public void handleRequest(String requestType) {
        if(requestType.equals("refund")){
            System.out.println("Billing support : Handling the refund request");
        }else if(nextHandler != null){
            nextHandler.handleRequest(requestType);
        }
    }

}
