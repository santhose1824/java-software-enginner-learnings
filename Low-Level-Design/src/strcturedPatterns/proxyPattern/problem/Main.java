package strcturedPatterns.proxyPattern.problem;

/*
     The actual problem is pretty straight forward that if you see the user1 download the video,
     user2 also download the same video.
     So it will do the same thing twice
     So what might be we thinking of it the solution is use caching logic ot use DP.
     We can do that but if we do inside the downloadVideo() that violates the SRP.
     This is solved by Proxy Pattern.

    Proxy is Layer that checks and allows use to interact with the service.
    Every Website has the ProxyLayer.
*/

public class Main {
    public static void main(String[] args) {
        VideoDownloader videoDownloader = new VideoDownloader();
        videoDownloader.downloadVideo("https://www.google.com");
        videoDownloader.downloadVideo("https://www.google.com");
    }
}
