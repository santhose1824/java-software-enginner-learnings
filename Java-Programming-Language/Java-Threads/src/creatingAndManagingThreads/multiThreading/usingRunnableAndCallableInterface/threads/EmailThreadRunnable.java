package creatingAndManagingThreads.multiThreading.usingRunnableAndCallableInterface.threads;

public class EmailThreadRunnable implements Runnable {
    public void run(){
        try {
            Thread.sleep(5000);
            System.out.println("["+Thread.currentThread().getName()+"] Send Email!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
