package behaviourPatterns.mediatorPattern.mediatorPatternExample.interfaces;

import behaviourPatterns.mediatorPattern.mediatorPatternExample.User;

public interface DocumentSessionMediator {
    void broadcastChange(String change, User sender);
    void join(User user);

}
