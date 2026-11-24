package creatingAndManagingThreads.multiThreading.usingRunnableAndCallableInterface;

import creatingAndManagingThreads.multiThreading.usingRunnableAndCallableInterface.threads.ETACalculatorCallable;
import creatingAndManagingThreads.multiThreading.usingRunnableAndCallableInterface.threads.EmailThreadRunnable;
import creatingAndManagingThreads.multiThreading.usingRunnableAndCallableInterface.threads.SMSThreadRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        System.out.println("Tasks are started");
        SMSThreadRunnable smsThreadRunnable = new SMSThreadRunnable();
        Thread smsThread = new Thread(smsThreadRunnable);
        smsThread.start();
        System.out.println("Tasks are ongoing ....");
        EmailThreadRunnable  emailThreadRunnable = new EmailThreadRunnable();
        Thread emailThread = new Thread(emailThreadRunnable);
        emailThread.start();
        System.out.println("Tasks are ongoing ....");
        FutureTask<String> etaRunnable = new FutureTask(new ETACalculatorCallable("Chennai"));
        Thread etaThread = new Thread(etaRunnable);
        etaThread.start();
        System.out.println("Tasks are ongoing ....");

        try {
            smsThread.join();
            emailThread.join();
            String eta = etaRunnable.get();
            System.out.println("ETA(Estimated Time calculation) is : "+eta);
            System.out.println("Tasks are done");
        }catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
