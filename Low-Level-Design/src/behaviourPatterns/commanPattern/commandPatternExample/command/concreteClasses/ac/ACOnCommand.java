package behaviourPatterns.commanPattern.commandPatternExample.command.concreteClasses.ac;

import behaviourPatterns.commanPattern.commandPatternExample.receiver.AC;
import behaviourPatterns.commanPattern.commandPatternExample.command.interfaces.Command;

public class ACOnCommand implements Command {
    private AC ac;

    public ACOnCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.on();
    }

    @Override
    public void undo() {
        ac.off();
    }
}
