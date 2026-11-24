package threadPoolAndExecutors.executorFramework.fixedThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Future<String>> futures = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            Future<String> future = executorService.submit(() -> {
                String thread = Thread.currentThread().getName();
                System.out.println("[RUNNING] Task " + taskId + " on " + thread);
                Thread.sleep(3000);
                return "hello from task " + taskId + " (" + thread + ")";
            });
            futures.add(future);
        }

        System.out.println("Doing some work....");

        for (Future<String> f : futures) {
            System.out.println(f.get());
        }

        executorService.shutdown();
    }
}
