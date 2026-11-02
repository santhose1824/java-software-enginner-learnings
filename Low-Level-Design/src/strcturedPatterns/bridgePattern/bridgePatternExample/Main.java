package strcturedPatterns.bridgePattern.bridgePatternExample;

import strcturedPatterns.bridgePattern.bridgePatternExample.concreteClasses.HDQuality;
import strcturedPatterns.bridgePattern.bridgePatternExample.concreteClasses.SDQuality;
import strcturedPatterns.bridgePattern.bridgePatternExample.concreteClasses.UltraHDQuality;
import strcturedPatterns.bridgePattern.bridgePatternExample.interfaces.VideoQuality;
import strcturedPatterns.bridgePattern.bridgePatternExample.services.WebPlayer;

/*
    Here we the abstract class as bridge to make create the all type of quality  with whatever the device type we want.
*/

public class Main {
    public static void main(String[] args) {
        VideoQuality WebHdVideoQuality = new WebPlayer(new HDQuality());
        WebHdVideoQuality.play("Leo Songs ");

        VideoQuality WebSDVideoQuality = new WebPlayer(new SDQuality());
        WebSDVideoQuality.play("Leo Songs ");

        VideoQuality WebUltraVideoQuality = new WebPlayer(new UltraHDQuality());
        WebUltraVideoQuality.play("Leo Songs ");
    }
}
