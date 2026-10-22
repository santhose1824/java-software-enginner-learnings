package interfaces.interrface_example;


// An interface in Java defines a contract that specifies the behavior implementing classes are expected to provide. It is primarily used to achieve abstraction and allows a class to implement multiple interfaces, supporting multiple inheritance of type in Java.
public interface Engine {

    // The variables/propeties that we are created is static and final default
    int price =  7800;

    void start();
    void accelerate();
    void stop();
}
