package behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample.handlers;

import behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample.abstractClasses.SupportHandler;

public class GeneralSupport  extends SupportHandler {
    public void handleRequest(String requestType) {
        if (requestType.equalsIgnoreCase("general")) {
            System.out.println("General Support : Handling general query");
        }else if(nextHandler != null){
            nextHandler.handleRequest(requestType);
        }
    }
}
