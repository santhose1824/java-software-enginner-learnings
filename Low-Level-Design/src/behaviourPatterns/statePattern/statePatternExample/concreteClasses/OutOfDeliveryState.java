package behaviourPatterns.statePattern.statePatternExample.concreteClasses;

import behaviourPatterns.statePattern.statePatternExample.context.OrderContext;
import behaviourPatterns.statePattern.statePatternExample.interfaces.OrderState;

public class OutOfDeliveryState implements OrderState {
    @Override
    public void next(OrderContext ordercontext) {
        ordercontext.setState(new DeliveredState());
        System.out.println("Order has been delivered");
    }

    @Override
    public void cancel(OrderContext orderContext) {
        orderContext.setState(new CancelState());
        System.out.println("Cannot cancel, Order is out for delivery");
    }

    @Override
    public String getStateName() {
        return "OUT_OF_DELIVERY";
    }
}
