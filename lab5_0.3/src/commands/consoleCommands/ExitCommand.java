package commands.consoleCommands;

import Interfaces.Executable;
import commands.absctractCommands.ConsoleCommand;
import console.ConsoleProcessor;
import exceptions.CommandException;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode

public class ExitCommand extends ConsoleCommand implements Executable {


    public ExitCommand(ConsoleProcessor consoleProcessor) {
        super(consoleProcessor);
    }


    @Override
    public String ExecuteCommand(String... args) {
        System.exit(0);
        return "programm is finished";
    }

    @Override
    public String getCommandArguments() {
        return "";
    }
}
