package behaviourPatterns.iteratorPattern.iteratorPatternExample.concreteClasses;

import behaviourPatterns.iteratorPattern.iteratorPatternExample.interfaces.PlayListIterator;
import behaviourPatterns.iteratorPattern.iteratorPatternExample.services.Video;

import java.util.List;

public class YoutubePlayListIterator implements PlayListIterator {
    private List<Video> videos;
    private int position;

    public YoutubePlayListIterator(List<Video> videos){
        this.videos = videos;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < videos.size();
    }

    @Override
    public Video next() {
        return hasNext() ? videos.get(position++) : null;
    }
}
