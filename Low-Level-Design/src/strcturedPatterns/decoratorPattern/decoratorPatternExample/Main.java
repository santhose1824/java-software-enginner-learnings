package strcturedPatterns.decoratorPattern.decoratorPatternExample;

import strcturedPatterns.decoratorPattern.decoratorPatternExample.concreteClass.ChickenPizza;
import strcturedPatterns.decoratorPattern.decoratorPatternExample.concreteClass.NormalPizza;
import strcturedPatterns.decoratorPattern.decoratorPatternExample.concreteDecoratorClass.ExtraCheese;
import strcturedPatterns.decoratorPattern.decoratorPatternExample.concreteDecoratorClass.MozzarellaCheese;
import strcturedPatterns.decoratorPattern.decoratorPatternExample.interfaces.Pizza;


/*
    In this I solve our previous problem how let's see.
    I have the interface, and it is implemented the base class(variety).
    So I created an abstract class that take the interface type object as parameter via constructor.
    Then I created a child classes(varieties) and extend my abstract class.
    My abstract class implements the interface, so whoever inherit my abstract class needs to implements that.
    My child class will get the constructor and pass it to the parent abstract class.
    So when I use the base combined with whatever I want to merge with single object.

    So here you can see the example I want variety of pizza's instead of creating so many classes and objects.
    I created one object which handles inheritance and creating all objects that needed for that.

*/

public class Main {
    public static void main(String[] args) {

        Pizza pizza = new NormalPizza();
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getPrice());

        Pizza normalPizzaWithExtraCheese = new ExtraCheese(new NormalPizza());
        System.out.println(normalPizzaWithExtraCheese.getDescription());
        System.out.println(normalPizzaWithExtraCheese.getPrice());

        Pizza normalPizzaWithMozzarellaCheese = new MozzarellaCheese(new NormalPizza());
        System.out.println(normalPizzaWithMozzarellaCheese.getDescription());
        System.out.println(normalPizzaWithMozzarellaCheese.getPrice());


        Pizza chickePizza = new ChickenPizza();
        System.out.println(chickePizza.getDescription());
        System.out.println(chickePizza.getPrice());

        Pizza chickenPizzaWithExtraCheese = new ExtraCheese(new ChickenPizza());
        System.out.println(chickenPizzaWithExtraCheese.getDescription());
        System.out.println(chickenPizzaWithExtraCheese.getPrice());

        Pizza chickenPizzaWithMozzarellaCheese = new MozzarellaCheese(new ChickenPizza());
        System.out.println(chickenPizzaWithMozzarellaCheese.getDescription());
        System.out.println(chickenPizzaWithMozzarellaCheese.getPrice());
    }
}
