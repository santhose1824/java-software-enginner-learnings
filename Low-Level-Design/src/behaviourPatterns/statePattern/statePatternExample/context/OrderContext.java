package behaviourPatterns.statePattern.statePatternExample.context;

import behaviourPatterns.statePattern.statePatternExample.concreteClasses.OrderPlacedState;
import behaviourPatterns.statePattern.statePatternExample.interfaces.OrderState;

public class OrderContext {
    private OrderState currentState;

        public OrderContext() {
            this.currentState = new OrderPlacedState();
        }

        public void setState(OrderState state) {
            this.currentState = state;
        }

        public void next(){
            this.currentState.next(this);
        }


        public void cancel(){
            this.currentState.cancel(this);
        }

        public String getStateName() {
            return this.currentState.getStateName();
        }
}
