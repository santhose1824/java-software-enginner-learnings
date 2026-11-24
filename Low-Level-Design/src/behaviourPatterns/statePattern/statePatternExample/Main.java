package behaviourPatterns.statePattern.statePatternExample;

import behaviourPatterns.statePattern.statePatternExample.context.OrderContext;

/*
    Here we separate each and every state, the context is the only thing the client is interacted,
    but each and every state is interacted with one another.

    Based on the state you can able to change whatever you want in UI as well as backend.
*/


public class Main {
    public static void main(String[] args) {
        OrderContext context = new OrderContext();

        System.out.println("Current State : "+context.getStateName());

        context.next();
        System.out.println("Current State : "+context.getStateName());

        context.next();
        System.out.println("Current State : "+context.getStateName());

        context.cancel();
        System.out.println("Current State : "+context.getStateName());

        context.next();
        System.out.println("Current State : "+context.getStateName());

        context.cancel();
        System.out.println("Current State : "+context.getStateName());
    }
}
