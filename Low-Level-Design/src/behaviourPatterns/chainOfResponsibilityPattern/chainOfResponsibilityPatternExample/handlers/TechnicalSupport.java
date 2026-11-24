package behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample.handlers;

import behaviourPatterns.chainOfResponsibilityPattern.chainOfResponsibilityPatternExample.abstractClasses.SupportHandler;

public class TechnicalSupport extends SupportHandler {

    public void handleRequest(String requestType){
        if(requestType.equals("technical")){
            System.out.println("Technical Support : Handling the technical issue");
        }else if(nextHandler != null){
            nextHandler.handleRequest(requestType);
        }
    }
}
