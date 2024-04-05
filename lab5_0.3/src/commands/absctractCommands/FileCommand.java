package commands.absctractCommands;

import Interfaces.Executable;
import commands.absctractCommands.Command;
import exceptions.CommandException;

public abstract class FileCommand extends Command implements Executable {
    @Override
    public abstract String ExecuteCommand(String... args);
}
