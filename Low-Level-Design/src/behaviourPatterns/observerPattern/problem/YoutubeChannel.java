package behaviourPatterns.observerPattern.problem;

public class YoutubeChannel {
    public void uploadVideo(String videoTitle){
        System.out.println("Uploading " + videoTitle);

        // Manually notify to users.
        System.out.println("Sending email to santhose18gmail.com");
        System.out.println("Pushing in-app notification to santhose18gmail.com");
    }
}
