package behaviourPatterns.iteratorPattern.iteratorPatternExample;

import behaviourPatterns.iteratorPattern.iteratorPatternExample.interfaces.PlayListIterator;
import behaviourPatterns.iteratorPattern.iteratorPatternExample.services.Video;
import behaviourPatterns.iteratorPattern.iteratorPatternExample.services.YouTubePlayList;

/*
    Instead of depend on knowing Data Structure and looping through using for loop.
    I use Iterator which has 2 methods hasNext() and next(), which will loop all the values for me.
    And then we create a Iterable interface called PlayList which has creator method.
    We implement in the YoutubePlayList class and create an object of YoutubeIterator and add playlist to the constructor.

*/

public class Main {
    public static void main(String[] args) {
        YouTubePlayList youTubePlayList = new YouTubePlayList();
        youTubePlayList.addVideo(new Video("Introduction to LLD(Low-Level-Design)"));
        youTubePlayList.addVideo(new Video("Introduction to SOLID Principles"));

        PlayListIterator iterator = youTubePlayList.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }
    }
}
