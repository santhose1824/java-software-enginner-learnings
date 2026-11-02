package strcturedPatterns.bridgePattern.bridgePatternExample.concreteClasses;

import strcturedPatterns.bridgePattern.bridgePatternExample.interfaces.VideoQuality;

public class HDQuality implements VideoQuality {
    @Override
    public void play(String title) {
        System.out.println(title+"Video is playing in HD Quality");
    }
}
