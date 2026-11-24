package behaviourPatterns.strategyPattern.strategyPatternExample.concreteClasses;

import behaviourPatterns.strategyPattern.strategyPatternExample.interfaces.MatchingStrategy;

public class SurgePriorityStrategy implements MatchingStrategy {
    @Override
    public void matching(String riderLocation) {
        System.out.println("Matching rider using surge priority near : "+riderLocation);
    }
}
