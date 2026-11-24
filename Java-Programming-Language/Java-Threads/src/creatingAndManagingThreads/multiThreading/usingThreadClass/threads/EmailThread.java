package creatingAndManagingThreads.multiThreading.usingThreadClass.threads;

public class EmailThread extends Thread {
    public void run(){
        try {
            Thread.sleep(5000);
            System.out.println("Email Send!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
