package behaviourPatterns.visitorPattern.vistorPatternExample.visitors;

import behaviourPatterns.visitorPattern.vistorPatternExample.interfaces.ItemVisitor;
import behaviourPatterns.visitorPattern.vistorPatternExample.products.DigitalProduct;
import behaviourPatterns.visitorPattern.vistorPatternExample.products.GiftCard;
import behaviourPatterns.visitorPattern.vistorPatternExample.products.PhysicalProduct;

public class ShippingCostVisitor implements ItemVisitor{

    @Override
    public void visit(PhysicalProduct item) {
        System.out.println("Shipping cost for " + item.name + ": Rs. " + (item.weight * 10));
    }

    @Override
    public void visit(DigitalProduct item) {
        System.out.println(item.name + " is digital -- No shipping cost.");
    }

    @Override
    public void visit(GiftCard item) {
        System.out.println("GiftCard delivery via email -- No shipping cost.");
    }
}
