package threadPoolAndExecutors.executorFramework.fixedThread;


/*
    Problem Statement is simple need to send emails to all users simultaneously
*/

public class Main {
    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        for(int i = 1; i <= 20; i++){
            emailService.sendEmail("user" +i+ "@gamil.com");
        }

        emailService.shutdown();
    }
}
