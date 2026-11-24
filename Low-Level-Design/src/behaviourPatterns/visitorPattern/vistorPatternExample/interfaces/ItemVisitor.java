package behaviourPatterns.visitorPattern.vistorPatternExample.interfaces;

import behaviourPatterns.visitorPattern.vistorPatternExample.products.GiftCard;
import behaviourPatterns.visitorPattern.vistorPatternExample.products.PhysicalProduct;
import behaviourPatterns.visitorPattern.vistorPatternExample.products.DigitalProduct;

public interface ItemVisitor {
    void visit(PhysicalProduct item);
    void visit(DigitalProduct item);
    void visit(GiftCard item);
}
