package strcturedPatterns.decoratorPattern.decoratorPatternExample.decoratorClass;

import strcturedPatterns.decoratorPattern.decoratorPatternExample.interfaces.Pizza;

abstract public class PizzaDecorator implements Pizza {
    protected  Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}
