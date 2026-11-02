package strcturedPatterns.bridgePattern.problem.concreteClasses;

import strcturedPatterns.bridgePattern.problem.interfaces.PlayQuality;

public class WebHD implements PlayQuality {
    @Override
    public void play(String title) {
        System.out.println("WebHD playing : " + title+" in HD");
    }
}
