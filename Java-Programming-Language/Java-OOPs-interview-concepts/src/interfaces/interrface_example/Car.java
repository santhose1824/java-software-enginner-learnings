package interfaces.interrface_example;

// To use interfaces we must use implements keyword
public class Car implements  Engine,Brakes{

    // These are abstract methods so we need to override.

    @Override
    public void brake() {
        System.out.println("I brake like a normal car");
    }

    @Override
    public void start() {
        System.out.println("I start like a normal car");
    }

    @Override
    public void accelerate() {
        System.out.println("I accelerate like a normal car");
    }

    @Override
    public void stop() {
        System.out.println("I stop like a normal car");
    }

}
