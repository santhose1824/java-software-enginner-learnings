package strcturedPatterns.decoratorPattern.decoratorPatternExample.concreteClass;

import strcturedPatterns.decoratorPattern.decoratorPatternExample.interfaces.Pizza;

public class NormalPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Veggie Pizza";
    }

    @Override
    public double getPrice() {
        return 200.00;
    }
}
