package commands.absctractCommands;

import Interfaces.Executable;

public abstract class Command implements Executable {
    public abstract String ExecuteCommand(String... args);
    public abstract String getCommandArguments();
}
