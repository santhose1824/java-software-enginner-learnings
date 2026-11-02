package creationalPatterns.prototypePattern.problem.concreteClasses;

import creationalPatterns.prototypePattern.problem.interfaces.EmailTemplate;

public class WelcomeEmail implements EmailTemplate {

    private String subject;
    private String content;

    public  WelcomeEmail(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    @Override
    public void setContent() {
        System.out.println(content);

    }

    @Override
    public void send(String to) {
        System.out.println("Sending email to " + to + "["+subject+"]..."+content);
    }
}
