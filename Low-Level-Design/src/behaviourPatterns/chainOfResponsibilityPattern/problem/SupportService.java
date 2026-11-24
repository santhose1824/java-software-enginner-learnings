package behaviourPatterns.chainOfResponsibilityPattern.problem;

public class SupportService {
    public void handleRequest(String type){
        if(type.equals("general")){
            System.out.println("Handled by General Support");
        }else if(type.equals("refund")){
            System.out.println("Handled by Billing Team");
        }else if(type.equals("technical")){
            System.out.println("Handled by Technical Support");
        }else if(type.equals("delivery")){
            System.out.println("Handled by Delivery Team");
        }else{
            System.out.println("No handler available");
        }
    }
}
