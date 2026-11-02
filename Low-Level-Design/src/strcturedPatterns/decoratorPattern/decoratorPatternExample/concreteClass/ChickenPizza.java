package strcturedPatterns.decoratorPattern.decoratorPatternExample.concreteClass;

import strcturedPatterns.decoratorPattern.decoratorPatternExample.interfaces.Pizza;

public class ChickenPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Chicken Pizza";
    }

    @Override
    public double getPrice() {
        return 400.00;
    }

}
