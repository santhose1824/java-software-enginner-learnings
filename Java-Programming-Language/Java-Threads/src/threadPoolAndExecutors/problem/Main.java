package threadPoolAndExecutors.problem;

/*
    Let's say you build a ride-matching system like Uber.
    Everytime a ride request is comes in, you spin a new thread to match a rider to a driver.
*/

public class Main {
    public static void main(String[] args) {
        RiderMatchingService riderMatchingService1 = new RiderMatchingService();
        RiderMatchingService riderMatchingService2 = new RiderMatchingService();

        riderMatchingService1.requestRide("1335445");
        System.out.println("Task 1 running ...");
        riderMatchingService2.requestRide("133545665");
        System.out.println("Task 2 running ...");
    }
}
