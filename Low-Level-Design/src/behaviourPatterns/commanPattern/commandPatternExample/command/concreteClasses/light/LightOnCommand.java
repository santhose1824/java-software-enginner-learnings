package behaviourPatterns.commanPattern.commandPatternExample.command.concreteClasses.light;

import behaviourPatterns.commanPattern.commandPatternExample.receiver.Light;
import behaviourPatterns.commanPattern.commandPatternExample.command.interfaces.Command;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
