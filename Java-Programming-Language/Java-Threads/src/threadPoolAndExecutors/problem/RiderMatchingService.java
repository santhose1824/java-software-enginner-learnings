package threadPoolAndExecutors.problem;

public class RiderMatchingService {
    public void requestRide(String rideId){
        Thread matchThread = new Thread(()->{
            System.out.println("Matching rider "+rideId+" to a driver...");
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }

            System.out.println("Ride matched for rider : "+rideId);
        });

        matchThread.start();
    }
}
