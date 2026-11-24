package behaviourPatterns.commanPattern.problem;


/*
    Here we have Light and AC  class which handle both the on and off of their respective operations.
    But I want to make sure that the client do not directly works on with this objects.
    So I created a new class called Remote and do the on off operations for all.
    But this violates lot of principles Remote is tightly type coupled and separate methods for all.
*/

public class Main {
    public static void main(String[] args) {
        NaiveRemote remote = new NaiveRemote(new Light(),new AC());
        remote.pressLightOn();
        remote.pressLightOff();
        remote.pressACOn();
        remote.pressACOff();
        remote.pressUndo();
    }
}
