package creatingAndManagingThreads.multiThreading.usingRunnableAndCallableInterface.threads;

public class SMSThreadRunnable implements Runnable{
    public void run(){
        try {
            Thread.sleep(2000);
            System.out.println("["+Thread.currentThread().getName()+"] Send SMS!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
