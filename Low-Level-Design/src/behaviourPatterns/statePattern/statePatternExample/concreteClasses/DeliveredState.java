package behaviourPatterns.statePattern.statePatternExample.concreteClasses;

import behaviourPatterns.statePattern.statePatternExample.context.OrderContext;
import behaviourPatterns.statePattern.statePatternExample.interfaces.OrderState;

public class DeliveredState implements OrderState {
    @Override
    public void next(OrderContext ordercontext) {
        System.out.println("Order is already delivered");
    }

    @Override
    public void cancel(OrderContext orderContext) {
        System.out.println("Cannot cancel a delivered order");
    }

    @Override
    public String getStateName() {
        return "DELIVERED";
    }
}
