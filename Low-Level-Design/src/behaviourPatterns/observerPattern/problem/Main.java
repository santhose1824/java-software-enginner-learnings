package behaviourPatterns.observerPattern.problem;




/*
    Consider we have YouTube like app , we allow users to upload and video and get notify to the subscribers.
    The problem in our application design is that we do send notifications to users manually.
    Consider one channel has  1million subscribers shall we need to send this notification manually to the users.
    It is not follow the SRP.
    We are not allow users to turn on or off the notifications.

*/

public class Main {
    public static void main(String[] args) {
        YoutubeChannel youtubeChannel = new YoutubeChannel();
        youtubeChannel.uploadVideo("Video 1");
    }
}
