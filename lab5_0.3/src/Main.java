
import commands.CommandProcessor;
import commands.fileCommands.SaveCommand;
import console.ConsoleProcessor;
import database.DataBase;
import file.FileProcessor;
import lombok.SneakyThrows;
import package1.*;

import java.io.FileNotFoundException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        CommandProcessor commandProcessor = new CommandProcessor();
        DataBase dataBase = new DataBase(commandProcessor);
        ConsoleProcessor consoleProcessor = new ConsoleProcessor(commandProcessor);
        FileProcessor fileProcessor = new FileProcessor(commandProcessor);
        FileProcessor.Parser parser = new FileProcessor.Parser();
        commandProcessor.getCommands().put("save",new SaveCommand(dataBase, parser));


        dataBase.tickets.addAll(parser.readFromFile());
        consoleProcessor.consoleExecute();

    }
}

// tasks:

//переменная окружения
//команды: execute_script
//работа со скриптом
//добавить exceptions
