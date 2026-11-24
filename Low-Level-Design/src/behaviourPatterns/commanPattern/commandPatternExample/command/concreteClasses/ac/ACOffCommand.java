package behaviourPatterns.commanPattern.commandPatternExample.command.concreteClasses.ac;

import behaviourPatterns.commanPattern.commandPatternExample.receiver.AC;
import behaviourPatterns.commanPattern.commandPatternExample.command.interfaces.Command;

public class ACOffCommand implements Command {
    private AC ac;

    public ACOffCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.off();
    }

    @Override
    public void undo() {
        ac.on();
    }
}
