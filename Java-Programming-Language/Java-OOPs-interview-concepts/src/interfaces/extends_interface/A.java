package interfaces.extends_interface;

public interface A {
    // we can have static methods inside the interface but that needs to be defined inside the interface
    static void staticMethod() {
        System.out.println("Static method inside interface A");
    }
    void fun();
}
