package behaviourPatterns.visitorPattern.vistorPatternExample.products;

import behaviourPatterns.visitorPattern.vistorPatternExample.interfaces.Item;
import behaviourPatterns.visitorPattern.vistorPatternExample.interfaces.ItemVisitor;

public class DigitalProduct implements Item {
    public String name;
    int downloadSize;

    public DigitalProduct(String name, int downloadSize) {
        this.name = name;
        this.downloadSize = downloadSize;
    }

    public void accept(ItemVisitor visitor){
        visitor.visit(this);
    }
}
