package creationalPatterns.factoryPattern.factoryPatternExample.concreteClasses;

import creationalPatterns.factoryPattern.factoryPatternExample.interfaces.Delivery;

public class Train implements Delivery {
    @Override
    public void sendDelivery(){
        System.out.println("Train delivery has been send.");
    }
}
