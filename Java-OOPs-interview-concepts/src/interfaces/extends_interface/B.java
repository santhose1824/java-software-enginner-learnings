package interfaces.extends_interface;

// We can be able to inherit one interface to another
public interface B extends A {
    // We can be able to give the methods with body but we need to put the default before it
    default  void normalMethod(){
        System.out.println("Default method inside interface B");
    }
    void greet();
}
