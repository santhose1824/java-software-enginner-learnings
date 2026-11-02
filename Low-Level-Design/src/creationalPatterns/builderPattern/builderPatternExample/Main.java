package creationalPatterns.builderPattern.builderPatternExample;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // How to create a object.

        // I create the reference variable in the type of Burger class.
        // I call the inner static class constructor and pass my bun and patty.
        // Finally, I call the build() of static class to create the object of Burger class.
        Burger burger = new Burger.BurgerBuilder("Italian","chicken").build();

        System.out.println(burger);

        // If I want to add the optionalFields then, I create an object like this.

        Burger burger1 = new Burger.BurgerBuilder("Italian","chicken").withCheese(false)
                .withDrinks("Sprite").withSides("French Fries").withToppings(List.of("Pepper,Onion")).build();

        System.out.println(burger1);
    }
}
