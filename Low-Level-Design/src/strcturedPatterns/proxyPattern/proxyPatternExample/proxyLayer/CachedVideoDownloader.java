package strcturedPatterns.proxyPattern.proxyPatternExample.proxyLayer;

import strcturedPatterns.proxyPattern.proxyPatternExample.VideoDownloader;
import strcturedPatterns.proxyPattern.proxyPatternExample.interfaces.VideoDownload;

import java.util.HashMap;
import java.util.Map;

public class CachedVideoDownloader implements VideoDownload {
    private VideoDownloader videoDownloader;
    private Map<String, String> cache;;

    public CachedVideoDownloader() {
        this.videoDownloader = new VideoDownloader();
        this.cache = new HashMap<>();
    }


    @Override
    public String downloadVideo(String url) {
        if(cache.containsKey(url)) {
            System.out.println("Returning the cached Video : "+url);
            return cache.get(url);
        }
        System.out.println("Cache is missing...");
        String video = videoDownloader.downloadVideo(url);
        cache.put(url, video);
        return video;
    }
}
