package behaviourPatterns.mediatorPattern.mediatorPatternExample.collabrator;

import behaviourPatterns.mediatorPattern.mediatorPatternExample.User;
import behaviourPatterns.mediatorPattern.mediatorPatternExample.interfaces.DocumentSessionMediator;


import java.util.ArrayList;
import java.util.List;

public class CollaborativeDocument implements DocumentSessionMediator {

    private List<User> users = new ArrayList();

    @Override
    public void broadcastChange(String change, User sender) {
        for(User user : users){
            if( user != sender){
                user.receiveChange(change, sender);
            }
        }
    }

    @Override
    public void join(User user) {
        users.add(user);
    }
}
