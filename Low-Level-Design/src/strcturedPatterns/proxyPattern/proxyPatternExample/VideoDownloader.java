package strcturedPatterns.proxyPattern.proxyPatternExample;

import strcturedPatterns.proxyPattern.proxyPatternExample.interfaces.VideoDownload;

public class VideoDownloader implements VideoDownload {
    @Override
    public String downloadVideo(String url) {
        System.out.println("Downloading video: " + url);
        return "Video Content from "+ url;
    }
}

