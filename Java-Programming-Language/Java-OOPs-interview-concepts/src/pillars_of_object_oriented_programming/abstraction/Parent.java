package pillars_of_object_oriented_programming.abstraction;

// This is Abstract Class it only show the essentials not the implementation.
// If the class contains any one abstract method then the class needs to abstract as well.
public abstract class Parent {
    int age;
    // We are allowed to create a constructor of abstract class.
    public Parent(int age) {
        this.age = age;
    }
    abstract void career(String name);
    abstract void partner(String name, int age);

    // abstract class have static methods, but abstract methods should not be static.
    // because static methods cannot be overridden but abstract methods should be overridden.
    static void  staticMethod(){
        System.out.println("Static method from abstract class");
    }


    // abstract class can have the normal methods.
    void normalMethod(){
        System.out.println("Normal method from abstract class");
    }


}
