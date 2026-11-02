package creationalPatterns.prototypePattern.prototypePatternExample.concreteClasses;

import creationalPatterns.prototypePattern.prototypePatternExample.interfaces.EmailTemplates;

public class WelcomeEmail implements EmailTemplates {

    private String subject;
    private String content;

    public WelcomeEmail() {
        this.subject = "Welcome!";
        this.content = "Welcome to our application!";
    }

    @Override
    public WelcomeEmail clone() {
        try {
            return (WelcomeEmail) super.clone();
        } catch (CloneNotSupportedException e) {
            // Can't happen because we implement Cloneable
            throw new AssertionError(e);
        }
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void send(String to) {
        System.out.println("Sending email to " + to + " [" + subject + "] ... " + content);
    }
}