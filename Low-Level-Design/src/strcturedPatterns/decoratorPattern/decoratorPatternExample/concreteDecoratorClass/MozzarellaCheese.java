package strcturedPatterns.decoratorPattern.decoratorPatternExample.concreteDecoratorClass;

import strcturedPatterns.decoratorPattern.decoratorPatternExample.decoratorClass.PizzaDecorator;
import strcturedPatterns.decoratorPattern.decoratorPatternExample.interfaces.Pizza;

public class MozzarellaCheese extends PizzaDecorator {
    public MozzarellaCheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ",with Mozzarella Cheese";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 50.38;
    }
}
