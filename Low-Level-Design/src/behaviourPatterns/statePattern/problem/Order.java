package behaviourPatterns.statePattern.problem;


/*
    Consider we are developing the Food Delivery app. In the order page we have to show Order status,
    whether the order is process, delivered or out for deliver.

    But this code is not scalable we have all the business logic is in one place.
    So to avoid these knid of thing we use State pattern.
*/


public class Order {
    private String state;

    public Order() {
        this.state = "ORDER_STATE";
    }

    public void cancelOrder() {
       if(state.equals("ORDER_PLACED") || state.equals(("PREPARING"))){
           state = "CANCELLED";
           System.out.println("Order cancelled");
       }else{
           System.out.println("Cannot cancel order");
       }
    }


    public void nextState(){
        switch (state){
            case "ORDER_PLACED" -> state ="PREPARING";
            case "PREPARING" -> state ="OUT_FOR_DELIVERY";
            case "OUT_FOR_DELIVERY" -> state ="DELIVERED";
            default -> System.out.println("No next state from : "+state);
        }
    }

    public String getState(){
        return state;
    }


}
