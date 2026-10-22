package interfaces.extends_interface;

public class Main implements B {

    // Here we are implement both methods from interface A and B because the interface B inherit A.

    @Override
    public void greet() {
        System.out.println("Hello Welcome");
    }

    @Override
    public void fun() {
        System.out.println("Simple function");
    }

//    @Override
//    public void normalMethod() {
//        System.out.println("Normal method from Main class");
//    }

    public static void main(String[] args) {
        Main obj = new Main();
        // because the B inherit the A interface we can be able to access the methods in A as well.
        obj.greet();
        obj.fun();

        // static method inside the interface A.
        A.staticMethod();

        // method with default body is in the interface we can be able to override it as well.
        obj.normalMethod();
    }
}
