package behaviourPatterns.iteratorPattern.problem;


/*
    Consider we have an YouTube app.
    We allow the creator to add videos as playlist.
    Here we have 2 problems the YouTubePlaylist done 2 things create object and add videos to playlist.
    Another problem is the YouTube playlist is exposed that it have the List in type of Video which is vulnerable.
    In future I add the private videos for the private.
    Here you see the client can able to know everything what kind of DS we use and what kind of Type we use.
    To solve we have a solution called Iterator Pattern.
*/


public class Main {
    public static void main(String[] args) {
        YouTubePlayList videoOne  = new YouTubePlayList();
        videoOne.addVideo(new Video("LLD(Low-Level-Design) Introduction"));

        YouTubePlayList videoTwo  = new YouTubePlayList();
        videoTwo.addVideo(new Video("SOILD Principles"));

        for(Video video : videoOne.getVideoList()) {
            System.out.println(video.getTitle());
        }
    }
}
