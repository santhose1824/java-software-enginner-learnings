package strcturedPatterns.bridgePattern.bridgePatternExample.concreteClasses;

import strcturedPatterns.bridgePattern.bridgePatternExample.interfaces.VideoQuality;

public class SDQuality implements VideoQuality {
    @Override
    public void play(String title) {
        System.out.println(title+"Video is playing in SD Quality");
    }
}
