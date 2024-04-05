package commands.dataBaseCommands;
import Interfaces.Executable;
import commands.absctractCommands.DataBaseCommand;
import database.DataBase;
import lombok.EqualsAndHashCode;
import package1.Ticket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class PrintFieldDescendingPriceCommand extends DataBaseCommand implements Executable {
    final DataBase dataBase;

    public PrintFieldDescendingPriceCommand(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public String ExecuteCommand(String... args)  {
        List<Long> price = new ArrayList();

        for (Ticket ticket : dataBase.tickets){
            price.add(ticket.getPrice());
        }


        return price.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .map(line -> line + "\n")
                .collect(Collectors.joining());
    }

    @Override
    public String getCommandArguments() {
        return "";
    }
}
