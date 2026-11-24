package behaviourPatterns.strategyPattern.strategyPatternExample.concreteClasses;

import behaviourPatterns.strategyPattern.strategyPatternExample.interfaces.MatchingStrategy;

public class NearestDrivingStrategy implements MatchingStrategy {
    @Override
    public void matching(String riderLocation) {
        System.out.println("Matching with the nearest available driver to : "+riderLocation);
    }
}
