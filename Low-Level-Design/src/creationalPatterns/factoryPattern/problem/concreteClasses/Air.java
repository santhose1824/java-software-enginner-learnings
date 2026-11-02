package creationalPatterns.factoryPattern.problem.concreteClasses;

import creationalPatterns.factoryPattern.problem.interfaces.Delivery;

public class Air implements Delivery {
    @Override
    public void sendDelivery() {
        System.out.println("Air Delivery has been send");
    }
}
