package strcturedPatterns.decoratorPattern.decoratorPatternExample.concreteDecoratorClass;

import strcturedPatterns.decoratorPattern.decoratorPatternExample.decoratorClass.PizzaDecorator;
import strcturedPatterns.decoratorPattern.decoratorPatternExample.interfaces.Pizza;

public class ExtraCheese extends PizzaDecorator {
    public ExtraCheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + "with ExtraCheese";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 48.02;
    }
}
