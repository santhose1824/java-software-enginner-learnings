package creatingAndManagingThreads.multiThreading.usingThreadClass;

import creatingAndManagingThreads.multiThreading.usingThreadClass.threads.EmailThread;
import creatingAndManagingThreads.multiThreading.usingThreadClass.threads.SMSThread;

public class Main {
    public static void main(String[] args) {
        SMSThread smsThread = new SMSThread();
        EmailThread emailThread = new EmailThread();

        // Thread sms = new Thread(()-> senSMS()); - This is also possible.
        // sms.start();


        System.out.println("Tasks are started..");
        smsThread.start();
        System.out.println("Task 1 is ongoing....");
        emailThread.start();
        System.out.println("Task 2 is ongoing....");

        try{
            smsThread.join();
            emailThread.join();
            System.out.println("Tasks are done");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
