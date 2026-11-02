package strcturedPatterns.bridgePattern.problem.concreteClasses;

import strcturedPatterns.bridgePattern.problem.interfaces.PlayQuality;

public class SmartTVHD implements PlayQuality {
    @Override
    public void play(String title) {
        System.out.println("SmartTv HD playing : " + title+" in HD");
    }
}
