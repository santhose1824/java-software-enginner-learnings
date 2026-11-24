package behaviourPatterns.commanPattern.commandPatternExample.command.concreteClasses.light;

import behaviourPatterns.commanPattern.commandPatternExample.receiver.Light;
import behaviourPatterns.commanPattern.commandPatternExample.command.interfaces.Command;

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
