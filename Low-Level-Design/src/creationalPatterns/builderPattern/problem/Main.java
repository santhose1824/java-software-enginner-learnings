package creationalPatterns.builderPattern.problem;

// Consider we are developing the food delivery app.
/* Problem :
        I want a Burger so to make a Burger ,I want to know the BunType and the PattyType.
        We can able to add this as parameterized constructor.
        In future if we extend the Burger class with like what are sides, what kind of toppings and do you need cheese or not.
        Then if we added that also in constructor's parameter then it is too long, these are optional.
        If the user don't want they explicitly needs to say nul for all the optionals.
        It is not the good design.
 */
// We can have one solution that worth consider in this situation is constructor overloading.
// But that leads to so many combinations of constructor we need to create which is impossible.
// So use constructor overloading when optional parameter is just 1.
// Because Java doesn't support to assign default values of parameters if we are not assign values to it.

public class Main {
    public static void main(String[] args) {
        Burger burger = new Burger("italian","chicken");

        // If I had optional and I want to create a constructor for that.
        // And I don't want that optionals I explicitly needs to do like this.
        /*
           Burger burger = new Burger("Italian", "Chicken", null, null, false )
        */
    }
}
