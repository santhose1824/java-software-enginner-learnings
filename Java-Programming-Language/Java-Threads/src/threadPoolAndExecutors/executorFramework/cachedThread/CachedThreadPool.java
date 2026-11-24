package threadPoolAndExecutors.executorFramework.cachedThread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CachedThreadPool{
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Round 1: 5 tasks at the same time -> 5 new threads are created
        System.out.println("--- Round 1: 5 tasks ---");
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.execute(() -> {
                String thread = Thread.currentThread().getName();
                System.out.println("[RUNNING] Task " + taskId + " on " + thread);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("[DONE]    Task " + taskId + " on " + thread);
            });
        }

        // Wait so all threads in round 1 become idle
        Thread.sleep(2000);

        // Round 2: 5 more tasks -> idle threads from round 1 are REUSED
        System.out.println("--- Round 2: 5 tasks ---");
        for (int i = 6; i <= 10; i++) {
            final int taskId = i;
            executor.execute(() -> {
                String thread = Thread.currentThread().getName();
                System.out.println("[RUNNING] Task " + taskId + " on " + thread);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("[DONE]    Task " + taskId + " on " + thread);
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("All tasks finished.");
    }
}