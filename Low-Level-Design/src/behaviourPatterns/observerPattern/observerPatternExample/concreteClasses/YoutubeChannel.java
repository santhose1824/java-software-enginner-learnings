package behaviourPatterns.observerPattern.observerPatternExample.concreteClasses;

import behaviourPatterns.observerPattern.observerPatternExample.interfaces.Channel;
import behaviourPatterns.observerPattern.observerPatternExample.interfaces.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Channel {

    private List<Subscriber> subscribers = new ArrayList<>();
    private String channelName;


    public YoutubeChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String videoTitle) {
        for(Subscriber subscriber : subscribers){
            subscriber.update(videoTitle);
        }
    }


    public void uploadVideo(String videoTitle){
        System.out.println(channelName+": Video uploaded: "+videoTitle);
        notifySubscribers(videoTitle);
    }
}
