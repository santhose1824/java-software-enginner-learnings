package behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample.handlers;

import behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample.abstractClasses.SupportHandler;

public class DeliverySupport extends SupportHandler {

    public void handleRequest(String requestType){
        if(requestType.equals("delivery")){
            System.out.println("Delivery Team : Handling the delivery issue");
        }else if(nextHandler != null){
            nextHandler.handleRequest(requestType);
        }else{
            System.out.println("Delivery Support : No handler found for the request");
        }
    }
}
