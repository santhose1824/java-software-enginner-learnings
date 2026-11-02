package creationalPatterns.prototypePattern.prototypePatternExample;

import creationalPatterns.prototypePattern.problem.interfaces.EmailTemplate;
import creationalPatterns.prototypePattern.prototypePatternExample.interfaces.EmailTemplates;
import creationalPatterns.prototypePattern.prototypePatternExample.registry.EmailRegistry;

/*
    So here we are trying to send an email using a template for our application.
    But I want to send different email templates based on the purpose of the email.
    For example, if I want to send a Forgot Password email, I would again need to create
    a new object from scratch. That is not good.

    You might think of creating the object with the Singleton pattern, right?
    But there is a problem:
        With a Singleton, there is only ONE shared object across the whole application.
        If I change it for Forgot Password, the change is global, so when I access the
        Welcome email template later, it would be overridden by the Forgot Password content.

    Then what is the solution? That's where the Prototype Pattern comes in.
        We keep one ready-made object (the prototype) in a registry.
        Whenever we need it, we take a clone (copy) of that object and use the clone.
        Each clone is independent, so changing one never affects the original or the others.

    Note: super.clone() gives a shallow copy. For mutable fields (List, Date, etc.)
    we must copy them manually inside clone() to get a deep copy.
*/

public class Main {
    public static void main(String[] args) {
        EmailTemplates emailTemplate = EmailRegistry.getEmailTemplate("welcome");
        emailTemplate.send("santhosemaha18@gmail.com");
        emailTemplate.setContent("Enjoy our continuous and seamless service.");
        emailTemplate.setSubject("Welcome to our application!");


        EmailTemplates emailTemplate2 = EmailRegistry.getEmailTemplate("welcome");

        System.out.println(emailTemplate2.equals(emailTemplate));


    }
}
