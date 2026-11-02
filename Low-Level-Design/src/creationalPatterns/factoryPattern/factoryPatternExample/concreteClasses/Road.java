package creationalPatterns.factoryPattern.factoryPatternExample.concreteClasses;

import creationalPatterns.factoryPattern.factoryPatternExample.interfaces.Delivery;

public class Road implements Delivery {
    @Override
    public void sendDelivery() {
        System.out.println("Road Delivery has been send");
    }
}
