package creationalPatterns.prototypePattern.problem;

import creationalPatterns.prototypePattern.problem.concreteClasses.WelcomeEmail;
import creationalPatterns.prototypePattern.problem.interfaces.EmailTemplate;

/*
    So here we are try to send a email with the template for our application.
    But I want to send email template based on  what purpose the email was sent.
    For that If I want to send email for forgot password I again need to create an object.
    That is not good. You might think of creating a object with Singleton pattern right.
    But there is a problem:
        If we create with Singleton Pattern we are assign or change the object globally,
        So in future if I access the welcome email template it would be overridden by the Forgot Password template.
        Then what is the solution that's where prototype Pattern comes.
        It creates a clone(Deep clone) of object and use it.
*/

public class Main {
    public static void main(String[] args) {
        EmailTemplate emailTemplate = new WelcomeEmail("Welcome Email","Enjoy the seamless communication of ours");

        emailTemplate.setContent();
        emailTemplate.send("santhosehm@gmail.com");
    }
}
