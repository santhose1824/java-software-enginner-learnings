package behaviourPatterns.iteratorPattern.problem;

import java.util.ArrayList;
import java.util.List;

public class YouTubePlayList {
    private List<Video> plalist = new ArrayList<Video>();

    public void addVideo(Video video) {
        plalist.add(video);
    }

    public List<Video> getVideoList() {
        return plalist;
    }
}
