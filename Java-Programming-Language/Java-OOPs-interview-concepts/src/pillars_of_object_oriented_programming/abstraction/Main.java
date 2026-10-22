package pillars_of_object_oriented_programming.abstraction;

public class Main {
    public static void main(String[] args) {

        // Here the abstraction is achieved because we use the methods and not worry about how it implemented.

        Son son = new Son(25);
        son.career("Software Engineer");
        son.partner("Someone",23);

        Daughter daughter = new Daughter(22);
        daughter.career("Doctor");
        daughter.partner("Someone",24);


        /*
             Parent mom = new Parent();
             We are not allowed to create an object for abstract class.
        */

        // static method from abstract class.
        Parent.staticMethod();

        // We use Son (child class) to call the normal method from abstract class,
        // because abstract class will not able to create object
        son.normalMethod();

        // We can do this because the run time polymorphism determines which method should run based on object type.
        Parent parent = new Son(24);
        // this will print son' method implementation.
        parent.career("Software Engineer");
        parent.partner("Someone",23);


    }
}
