package interfaces.nested_interfaces;

public class NestedInterfaceExample {
    // We can create an interface inside the class that is called nested interface.
    // The only difference is we can give any access modifiers to the nested interface.
    // While we can be able to give public or default modifiers to the normal interface.

    protected interface NestedInterface {
        void nestedMethod();
    }


    NestedInterfaceExample(){

    }

    public static void staticMethod(){
        System.out.println("Static method inside Class Example ");
    }
}
