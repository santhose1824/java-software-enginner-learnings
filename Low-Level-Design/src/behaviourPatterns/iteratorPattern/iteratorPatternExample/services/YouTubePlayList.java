package behaviourPatterns.iteratorPattern.iteratorPatternExample.services;

import behaviourPatterns.iteratorPattern.iteratorPatternExample.concreteClasses.YoutubePlayListIterator;
import behaviourPatterns.iteratorPattern.iteratorPatternExample.interfaces.PlayList;
import behaviourPatterns.iteratorPattern.iteratorPatternExample.interfaces.PlayListIterator;

import java.util.ArrayList;
import java.util.List;

public class YouTubePlayList implements PlayList {
    private List<Video> plalist = new ArrayList<Video>();

    public void addVideo(Video video) {
        plalist.add(video);
    }

    @Override
    public PlayListIterator createIterator() {
        return new YoutubePlayListIterator(plalist);
    }
}
