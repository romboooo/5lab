package commands.absctractCommands;

import Interfaces.Executable;
import commands.absctractCommands.Command;
import console.ConsoleProcessor;
import exceptions.CommandException;

public abstract class ConsoleCommand extends Command implements Executable {
    protected final ConsoleProcessor consoleProcessor;

    protected ConsoleCommand(ConsoleProcessor consoleProcessor) {
        this.consoleProcessor = consoleProcessor;
    }


    @Override
    public String ExecuteCommand(String... args) {
        return null;
    }
}
