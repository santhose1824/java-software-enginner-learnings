package interfaces.nested_interfaces;



// This is how we can be able to implements nested interface
public class Main implements NestedInterfaceExample.NestedInterface {

    @Override
    public void nestedMethod() {
        System.out.println("Nested Interface method implements from the Main class ");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.nestedMethod();
        NestedInterfaceExample.staticMethod();
    }
}
