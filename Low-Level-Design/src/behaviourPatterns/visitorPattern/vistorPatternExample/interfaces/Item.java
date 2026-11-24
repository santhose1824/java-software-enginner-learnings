package behaviourPatterns.visitorPattern.vistorPatternExample.interfaces;

public interface Item {
    void  accept(ItemVisitor visitor);
}
