package strcturedPatterns.bridgePattern.problem.concreteClasses;

import strcturedPatterns.bridgePattern.problem.interfaces.PlayQuality;

public class MobileHD implements PlayQuality {
    public void play(String title) {
        System.out.println("Mobile HD:  playing " + title+" in HD");
    }
}
