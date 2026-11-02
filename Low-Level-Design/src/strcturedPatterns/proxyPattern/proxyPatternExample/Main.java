package strcturedPatterns.proxyPattern.proxyPatternExample;


/*
    I create an interface which I allow the client to create a object variable
    To create an object for videoDownloader I use Proxy layer of my to do that instead of doing with VideoDownloader class.
*/

import strcturedPatterns.proxyPattern.proxyPatternExample.interfaces.VideoDownload;
import strcturedPatterns.proxyPattern.proxyPatternExample.proxyLayer.CachedVideoDownloader;

public class Main {
    public static void main(String[] args) {
        VideoDownload videoDownloader = new CachedVideoDownloader();
        videoDownloader.downloadVideo("htttps://google.com");

        videoDownloader.downloadVideo("https://google.com");

    }
}
