package interfaces.interrface_example;

public class MusicSystem implements  MediaPlayer{
    @Override
    public void start() {
        System.out.println("Music System is started");
    }

    @Override
    public void stop() {
        System.out.println("Music System is stopped");
    }
}
