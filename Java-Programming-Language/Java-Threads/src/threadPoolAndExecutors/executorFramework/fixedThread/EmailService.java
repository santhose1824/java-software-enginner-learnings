package threadPoolAndExecutors.executorFramework.fixedThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailService {
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public void sendEmail(String recipient) {
        executor.execute(() -> {
            String thread = Thread.currentThread().getName();

            System.out.println("[RUNNING] " + thread + " -> sending email to " + recipient);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("[DONE]    " + thread + " -> email sent to " + recipient);
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}