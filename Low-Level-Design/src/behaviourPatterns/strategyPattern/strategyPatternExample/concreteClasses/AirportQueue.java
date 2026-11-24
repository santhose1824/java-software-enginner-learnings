package behaviourPatterns.strategyPattern.strategyPatternExample.concreteClasses;

import behaviourPatterns.strategyPattern.strategyPatternExample.interfaces.MatchingStrategy;

public class AirportQueue implements MatchingStrategy {
    @Override
    public void matching(String riderLocation) {
        System.out.println("Matching with FIFO airport queue for : "+riderLocation);
    }
}
