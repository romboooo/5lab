package commands.absctractCommands;

import Interfaces.Executable;
import commands.absctractCommands.Command;
import exceptions.CommandDoesntExists;
import exceptions.CommandException;

import java.io.FileNotFoundException;

public abstract class DataBaseCommand extends Command implements Executable {
    @Override
    public abstract String ExecuteCommand(String... args);
}
