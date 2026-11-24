package behaviourPatterns.commanPattern.commandPatternExample.client;

import behaviourPatterns.commanPattern.commandPatternExample.command.concreteClasses.ac.ACOffCommand;
import behaviourPatterns.commanPattern.commandPatternExample.command.concreteClasses.ac.ACOnCommand;
import behaviourPatterns.commanPattern.commandPatternExample.command.concreteClasses.light.LightOffCommand;
import behaviourPatterns.commanPattern.commandPatternExample.command.concreteClasses.light.LightOnCommand;
import behaviourPatterns.commanPattern.commandPatternExample.command.interfaces.Command;
import behaviourPatterns.commanPattern.commandPatternExample.invoker.Remote;
import behaviourPatterns.commanPattern.commandPatternExample.receiver.AC;
import behaviourPatterns.commanPattern.commandPatternExample.receiver.Light;

/*
    Here instead of we doing everything in the same class I create a client -> Invoker -> Command -> Receiver
    kind of stuffs.
*/

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        AC ac = new AC();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command acOn = new ACOnCommand(ac);
        Command acOff = new ACOffCommand(ac);


        Remote remote = new Remote();
        remote.setCommands(0,lightOn);
        remote.setCommands(1,lightOff);
        remote.setCommands(2,acOn);
        remote.setCommands(3,acOff);

        remote.pressButton(0);
        remote.pressButton(1);
        remote.pressButton(2);
        remote.pressButton(3);
        remote.pressUndo();
        remote.pressUndo();

    }
}
