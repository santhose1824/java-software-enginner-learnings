package behaviourPatterns.observerPattern.observerPatternExample.interfaces;

public interface Channel {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(String videoTitle);
}
