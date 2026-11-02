package strcturedPatterns.bridgePattern.bridgePatternExample.bridge;

import strcturedPatterns.bridgePattern.bridgePatternExample.interfaces.VideoQuality;

abstract public class VideoPlayer implements VideoQuality {
    protected VideoQuality  videoQuality;

    public VideoPlayer(VideoQuality videoQuality) {
        this.videoQuality = videoQuality;
    }

    public abstract void play(String title);
}
