package commands.processorsCommands;

import commands.CommandProcessor;
import commands.absctractCommands.Command;
import commands.absctractCommands.ProcessorsCommand;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class HelpCommand extends ProcessorsCommand {


    public HelpCommand(CommandProcessor processor) {
        super(processor);
    }


    @Override
    public String ExecuteCommand(String... args)  {
        List<String> AllCommands= new ArrayList<>();
        for (Map.Entry<String, Command> commandName : processor.getCommands().entrySet()){
            AllCommands.add(commandName.getKey() +commandName.getValue().getCommandArguments() + "\n");


        }
        return AllCommands.stream().collect(Collectors.joining());
    }

    @Override
    public String getCommandArguments() {
        return "";
    }
}
