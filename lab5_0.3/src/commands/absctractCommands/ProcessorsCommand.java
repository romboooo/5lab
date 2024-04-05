package commands.absctractCommands;


import Interfaces.Executable;
import commands.CommandProcessor;
import commands.absctractCommands.Command;
import exceptions.CommandDoesntExists;
import exceptions.CommandException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class ProcessorsCommand extends Command implements Executable {

    protected final CommandProcessor processor;


    @Override
    public abstract String ExecuteCommand(String... args);
}
