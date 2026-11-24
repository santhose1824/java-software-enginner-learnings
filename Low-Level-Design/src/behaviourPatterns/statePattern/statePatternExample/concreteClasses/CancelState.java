package behaviourPatterns.statePattern.statePatternExample.concreteClasses;

import behaviourPatterns.statePattern.statePatternExample.context.OrderContext;
import behaviourPatterns.statePattern.statePatternExample.interfaces.OrderState;

public class CancelState implements OrderState {
    @Override
    public void next(OrderContext ordercontext) {
        System.out.println("Cancel order cannot be moved to next state");
    }

    @Override
    public void cancel(OrderContext orderContext) {
        System.out.println("Order is already cancelled.");
    }

    @Override
    public String getStateName() {
        return "CANCELLED";
    }
}
