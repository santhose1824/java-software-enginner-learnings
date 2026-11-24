package behaviourPatterns.statePattern.statePatternExample.concreteClasses;

import behaviourPatterns.statePattern.statePatternExample.context.OrderContext;
import behaviourPatterns.statePattern.statePatternExample.interfaces.OrderState;

public class OrderPlacedState implements OrderState {
    @Override
    public void next(OrderContext ordercontext) {
        ordercontext.setState(new PreparingState());
        System.out.println("Order is now being prepared");
    }

    @Override
    public void cancel(OrderContext orderContext) {
        orderContext.setState(new CancelState());
        System.out.println("Order has been cancelled");
    }

    @Override
    public String getStateName() {
        return "ORDER_PLACED";
    }
}
