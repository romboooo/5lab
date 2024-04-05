package commands;

import commands.absctractCommands.Command;
import commands.processorsCommands.HelpCommand;
import exceptions.CommandDoesntExists;
import exceptions.CommandException;
import lombok.Getter;

import java.io.FileNotFoundException;
import java.util.HashMap;
@Getter
public class CommandProcessor {
    private HashMap<String, Command> commands = new HashMap<>();
    public CommandProcessor(){
        commands.put("help", new HelpCommand(this));


    }


    public String executeCommand(String input) throws CommandDoesntExists {

        String[] commandSplit = input.split(" ", 2);

        String commandName = commandSplit[0];
        String[] commandArguments = null;

        if (commandSplit.length == 2) {
            commandArguments = commandSplit[1].split(" ");
        }


        if (commands.containsKey(commandName)) {

            return commands.get(commandName).ExecuteCommand(commandArguments);
        } else {
            throw new CommandDoesntExists(input);
        }
    }
}
