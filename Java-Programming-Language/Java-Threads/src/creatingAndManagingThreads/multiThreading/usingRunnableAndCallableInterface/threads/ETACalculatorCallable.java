package creatingAndManagingThreads.multiThreading.usingRunnableAndCallableInterface.threads;

import java.util.concurrent.Callable;

public class ETACalculatorCallable implements Callable<String> {
    private final String location;

    public ETACalculatorCallable(String location) {
        this.location = location;
    }

    @Override
    public String call() throws Exception {
        System.out.println("["+Thread.currentThread().getName()+"] Calculating ETA(Estimated Arrival Time) to : "+location);
        Thread.sleep(5000);
        return "ETA(Estimated Arrival Time) to "+location+" : 20 minutes";
    }
}
