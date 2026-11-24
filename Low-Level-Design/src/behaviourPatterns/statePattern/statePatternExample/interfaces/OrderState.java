package behaviourPatterns.statePattern.statePatternExample.interfaces;


import behaviourPatterns.statePattern.statePatternExample.context.OrderContext;

public interface OrderState {
    void next(OrderContext ordercontext);
    void cancel(OrderContext orderContext);
    String getStateName();
}
