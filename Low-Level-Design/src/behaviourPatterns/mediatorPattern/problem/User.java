package behaviourPatterns.mediatorPattern.problem;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<User> others;

    public User(String name) {
        this.name = name;
        this.others = new ArrayList<>();
    }

    public void addCollaborator(User user){
        others.add(user);
    }

    public void makeChange(String change){
        System.out.println(name +" made a change : "+change);
        for (User user : others) {
            user.receiveChange(change, this);
        }
    }

    public void receiveChange(String change, User user){
        System.out.println(name +" received a change : "+change+ " from"+user.name);
    }
}
