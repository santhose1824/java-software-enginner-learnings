package creationalPatterns.factoryPattern.problem;

import creationalPatterns.factoryPattern.problem.service.DeliveryService;


// Problem - I want to get the correct deliveryService based on the mode.
public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();
        deliveryService.send("air");
    }
}
