package behaviourPatterns.strategyPattern.strategyPatternExample;


/*
    Here we just separate each and every matching strategy into concrete classes that implements MatchingStrategy inteface.
*/

import behaviourPatterns.strategyPattern.strategyPatternExample.concreteClasses.AirportQueue;
import behaviourPatterns.strategyPattern.strategyPatternExample.concreteClasses.NearestDrivingStrategy;
import behaviourPatterns.strategyPattern.strategyPatternExample.concreteClasses.SurgePriorityStrategy;

public class Main {
    public static void main(String[] args) {
        RideMatching rideMatching = new RideMatching(new AirportQueue());
        rideMatching.matchRider("gdgjfgojtoirjhiojh");

        RideMatching rideMatching2 = new RideMatching(new NearestDrivingStrategy());
        rideMatching2.matchRider("gdgjfgojtoirjh");
        rideMatching2.setStrategy(new SurgePriorityStrategy());
    }
}
