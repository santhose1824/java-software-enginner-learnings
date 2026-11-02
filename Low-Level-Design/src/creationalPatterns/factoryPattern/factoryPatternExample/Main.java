package creationalPatterns.factoryPattern.factoryPatternExample;

import creationalPatterns.factoryPattern.factoryPatternExample.service.DeliveryService;

public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();
        deliveryService.send("air");
    }
}
