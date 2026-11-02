package creationalPatterns.factoryPattern.factoryPatternExample.concreteClasses;

import creationalPatterns.factoryPattern.factoryPatternExample.interfaces.Delivery;

public class Air implements Delivery {
    @Override
    public void sendDelivery() {
        System.out.println("Air Delivery has been send");
    }
}
