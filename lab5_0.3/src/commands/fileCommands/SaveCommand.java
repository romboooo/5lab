package commands.fileCommands;
import Interfaces.Executable;
import commands.absctractCommands.FileCommand;
import database.DataBase;
import file.FileProcessor;
import lombok.EqualsAndHashCode;

import java.util.stream.Collectors;


@EqualsAndHashCode
public class SaveCommand extends FileCommand implements Executable {
    final DataBase dataBase;
    final FileProcessor.Parser parser;

    public SaveCommand(DataBase dataBase, FileProcessor.Parser parser) {
        this.dataBase = dataBase;
        this.parser = parser;
    }

    @Override
    public String ExecuteCommand(String... args) {
        parser.writeToFile(dataBase.tickets.stream().collect(Collectors.toList()));
        return "done!";
    }

    @Override
    public String getCommandArguments() {
        return "";
    }
}
