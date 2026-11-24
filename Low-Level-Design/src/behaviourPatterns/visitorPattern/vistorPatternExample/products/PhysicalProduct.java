package behaviourPatterns.visitorPattern.vistorPatternExample.products;

import behaviourPatterns.visitorPattern.vistorPatternExample.interfaces.Item;
import behaviourPatterns.visitorPattern.vistorPatternExample.interfaces.ItemVisitor;

public class PhysicalProduct implements Item {
    public String name;
    public double weight;

    public PhysicalProduct(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void accept(ItemVisitor visitor){
        visitor.visit(this);
    }
}
