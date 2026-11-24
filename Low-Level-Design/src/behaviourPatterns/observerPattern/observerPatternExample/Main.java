package behaviourPatterns.observerPattern.observerPatternExample;




/*
    So we solve each problem here first to subscribe we have an interface that helps us to handle all kind of subscriptions.
    As of now we have email and mobile app.
    Then we have channel interface that will help us to handle notification triggers and subscriptions for particular channel.
    Then we have Youtube Channel class that implements all the methods in channels interface.
*/

import behaviourPatterns.observerPattern.observerPatternExample.concreteClasses.EmailSubscriber;
import behaviourPatterns.observerPattern.observerPatternExample.concreteClasses.MobileAppSubscriber;
import behaviourPatterns.observerPattern.observerPatternExample.concreteClasses.YoutubeChannel;

public class Main {
    public static void main(String[] args) {
        YoutubeChannel youtubeChannel = new YoutubeChannel("Java Learnings");
        youtubeChannel.subscribe(new EmailSubscriber("santhosemaha18@gmail.com"));
        youtubeChannel.subscribe(new MobileAppSubscriber("santhosemaha18"));
        youtubeChannel.subscribe(new MobileAppSubscriber("santhosemaha19"));
        youtubeChannel.uploadVideo("Video 1");


    }
}
