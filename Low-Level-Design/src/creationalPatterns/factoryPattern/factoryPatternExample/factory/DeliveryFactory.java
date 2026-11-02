package creationalPatterns.factoryPattern.factoryPatternExample.factory;

import creationalPatterns.factoryPattern.factoryPatternExample.concreteClasses.Air;
import creationalPatterns.factoryPattern.factoryPatternExample.concreteClasses.Road;
import creationalPatterns.factoryPattern.factoryPatternExample.concreteClasses.Train;
import creationalPatterns.factoryPattern.factoryPatternExample.interfaces.Delivery;

// In future If I want to add new DeliveryService I just modify this and not touch the main code.
public class DeliveryFactory {
    public static Delivery sendDelivery(String mode){
        if(mode.equalsIgnoreCase("road")){
            return new Road();
        } else if (mode.equalsIgnoreCase("train")) {
            return new Train();
        }
        return new Air();
    }
}
