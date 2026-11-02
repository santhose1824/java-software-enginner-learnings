package creationalPatterns.factoryPattern.factoryPatternExample.service;

import creationalPatterns.factoryPattern.factoryPatternExample.concreteClasses.Air;
import creationalPatterns.factoryPattern.factoryPatternExample.concreteClasses.Road;
import creationalPatterns.factoryPattern.factoryPatternExample.factory.DeliveryFactory;
import creationalPatterns.factoryPattern.factoryPatternExample.interfaces.Delivery;

// What Factory pattern told is - it lets you create objects without telling your code exactly which class to use.
// The two major problems was solved it will follow SRP, and follow OCP(Open and Closed Principle) as well.
// In future if I had another delivery service I had to modify the DeliveryFactory code that would not affect the application.
public class DeliveryService {
   public void send(String mode){
       /*
            if(mode.equalsIgnoreCase("Air")){
                Delivery delivery = new Air();
                delivery.sendDelivery();
            }else if(mode.equalsIgnoreCase("Road")){
                Delivery delivery = new Road();
                delivery.sendDelivery();
            }
       */

       // So instead of this I will do

       Delivery delivery = DeliveryFactory.sendDelivery(mode);
       delivery.sendDelivery();
    }
}
