package creationalPatterns.factoryPattern.problem.concreteClasses;

import creationalPatterns.factoryPattern.problem.interfaces.Delivery;

public class Road implements Delivery {
    @Override
    public void sendDelivery() {
        System.out.println("Road Delivery has been send");
    }
}
