package creatingAndManagingThreads.multiThreading.usingThreadClass.threads;

public class SMSThread extends Thread{
    public void run(){
        try {
            Thread.sleep(2000);
            System.out.println("SMS Send!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
