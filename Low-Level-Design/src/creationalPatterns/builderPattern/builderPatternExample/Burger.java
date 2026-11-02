package creationalPatterns.builderPattern.builderPatternExample;

import java.util.List;

public class Burger {
    // Required fields.
    private final String bunType;
    private final String patty;

    // Optional fields.
    private final String sides;
    private final List<String> toppings;
    private final String drinks;
    private final boolean hasCheese;


    // This constructor takes the parameter of BurgerBuilder class object.
    // And assign that object's attribute values to the Burger class attributes.
    // Why I put all fields means - I want to know what the user wants including the optional even through sometimes they are not addd.
    public Burger(BurgerBuilder burgerBuilder){
        this.bunType = burgerBuilder.bunType;
        this.patty = burgerBuilder.patty;
        this.sides = burgerBuilder.sides;
        this.toppings = burgerBuilder.toppings;
        this.drinks = burgerBuilder.drinks;
        this.hasCheese = burgerBuilder.hasCheese;
    }

    // I create static class - this is mandatory to achieve builder pattern, and must be an inner class.
    public static class BurgerBuilder{
        // Required fields.
        private final String bunType;
        private final String patty;

        // Optional fields.
        private  String sides;
        private List<String> toppings;
        private String drinks;
        private boolean hasCheese;

        // This is the main constructor of the BurgerBuilder class, because I know to prepare Burger I want to know bunType and patty.
        public BurgerBuilder(String bunType, String patty){
            this.bunType = bunType;
            this.patty = patty;
        }

        // For the optionals I create a setter method and set the value if the user assign or else assign the current value.
        // I return this at then end because if the user assign the value first I need to give that value to the BurgerBuilder class attribute.
        public BurgerBuilder withSides(String sides){
            this.sides = sides;
            return this;
        }

        public BurgerBuilder withToppings(List<String> toppings){
            this.toppings = toppings;
            return this;
        }

        public BurgerBuilder withDrinks(String drinks){
            this.drinks = drinks;
            return this;
        }

        public  BurgerBuilder withCheese(boolean hasCheese){
            this.hasCheese = hasCheese;
            return this;
        }


        // Finally we use the build() to create an object of Burger class and return the object of it.
        public Burger build(){
            // Our outer class Burger has parameter of BurgerBuilder object.
            // So we send this(current object) of the BurgerBuilder class.
            return new Burger(this);
        }
    }

    @Override
    public String toString() {
        return "Burger{" +
                "bunType='" + bunType + '\'' +
                ", patty='" + patty + '\'' +
                ", sides='" + sides + '\'' +
                ", toppings=" + toppings +
                ", drinks='" + drinks + '\'' +
                ", hasCheese=" + hasCheese +
                '}';
    }
}
