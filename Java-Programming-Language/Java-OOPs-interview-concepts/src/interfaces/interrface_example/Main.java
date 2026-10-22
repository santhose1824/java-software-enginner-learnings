package interfaces.interrface_example;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        // Now we are achieving the multiple inheritance.
        // the start, accelerate and stop are from Engine, and brake from Brake.
        car.start();
        car.accelerate();
        car.brake();
        car.stop();

        // Here we need to understand 2 things that we can be able to create reference variable in the type of reference.
        // But it can access only the properties inside the particular interface
        // Also we can use the same interface for 2 different class that are not relate to each other
        MediaPlayer mediaPlayer = new MusicSystem();
        mediaPlayer.start();
        mediaPlayer.stop();

    }
}
