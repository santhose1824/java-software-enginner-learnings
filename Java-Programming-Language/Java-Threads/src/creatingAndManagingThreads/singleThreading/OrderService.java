package creatingAndManagingThreads.singleThreading;

// Single thread used by multiple tasks.

public class OrderService {
    public static void main(String[] args) {
        System.out.println("Placing an order.....");
        sendSMS();
        System.out.println("Task one done");
        sendEmail();
        System.out.println("Task two done");
        String eta = calculateETA();
        System.out.println("Order placed. Estimated Arrival Time is : "+eta);
        System.out.println("Task three done");
    }

    private static void sendSMS(){
        try {
            Thread.sleep(2000);
            System.out.println("SMS Send!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    private static void sendEmail(){
        try {
            Thread.sleep(3000);
            System.out.println("Email Send!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private static String calculateETA(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return "25 minutes";
    }
}
