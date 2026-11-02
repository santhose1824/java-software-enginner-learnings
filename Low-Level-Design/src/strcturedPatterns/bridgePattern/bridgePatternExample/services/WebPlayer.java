package strcturedPatterns.bridgePattern.bridgePatternExample.services;

import strcturedPatterns.bridgePattern.bridgePatternExample.bridge.VideoPlayer;
import strcturedPatterns.bridgePattern.bridgePatternExample.interfaces.VideoQuality;

public class WebPlayer extends VideoPlayer {
    public WebPlayer(VideoQuality videoQuality) {
        super(videoQuality);
    }

    @Override
    public void play(String title) {
        videoQuality.play(title);
    }
}
