package behaviourPatterns.strategyPattern.strategyPatternExample;

import behaviourPatterns.strategyPattern.strategyPatternExample.interfaces.MatchingStrategy;

public class RideMatching {
    private MatchingStrategy strategy;

    public RideMatching(MatchingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(MatchingStrategy strategy) {
        this.strategy = strategy;
    }

    public void matchRider(String location){
        strategy.matching(location);
    }
}
