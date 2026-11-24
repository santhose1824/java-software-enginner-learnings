package behaviourPatterns.observerPattern.observerPatternExample.concreteClasses;

import behaviourPatterns.observerPattern.observerPatternExample.interfaces.Subscriber;

public class MobileAppSubscriber implements Subscriber {
    private String userName;

    public MobileAppSubscriber(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("In app notification for :"+userName+": New video uploaded: "+videoTitle);
    }
}
