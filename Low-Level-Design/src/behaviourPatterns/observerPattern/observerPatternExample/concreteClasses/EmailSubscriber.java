package behaviourPatterns.observerPattern.observerPatternExample.concreteClasses;

import behaviourPatterns.observerPattern.observerPatternExample.interfaces.Subscriber;

public class EmailSubscriber implements Subscriber {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("Email send to "+email+": New video uploaded: "+videoTitle);
    }

}
