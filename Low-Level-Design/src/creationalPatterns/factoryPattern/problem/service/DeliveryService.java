package creationalPatterns.factoryPattern.problem.service;

import creationalPatterns.factoryPattern.problem.concreteClasses.Air;
import creationalPatterns.factoryPattern.problem.concreteClasses.Road;
import creationalPatterns.factoryPattern.problem.interfaces.Delivery;

// The problem is it violates the SRP(Single Responsibility Principle) rule.
// It does 2 things checks which mode and creates the objects.
// Here the creation of object is the issue, so that's why it will come under creational design patterns.
// What Factory pattern told is - it lets you create objects without telling your code exactly which class to use.
// The two major problems here was first it will not follow SRP, and it will not follow OCP as well.
// In future if I had another delivery service I had to modify this code that would affect the application.
public class DeliveryService {
   public void send(String mode){
        if(mode.equalsIgnoreCase("Air")){
            Delivery delivery = new Air();
            delivery.sendDelivery();
        }else if(mode.equalsIgnoreCase("Road")){
            Delivery delivery = new Road();
            delivery.sendDelivery();
        }
    }
}
