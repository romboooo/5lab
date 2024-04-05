package commands.dataBaseCommands;
import Interfaces.Executable;
import commands.absctractCommands.DataBaseCommand;

import database.DataBase;
import lombok.EqualsAndHashCode;
import package1.Ticket;

import java.util.Collections;

@EqualsAndHashCode
public class InfoCommand extends DataBaseCommand implements Executable {


    final DataBase dataBase;

    public InfoCommand(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String ExecuteCommand(String... args) {
        int count = 0;
        System.out.println("collection type: " + dataBase.tickets.getClass());

        System.out.println("initialization date: " + dataBase.tickets.getFirst().getCreationDate());

        for(Ticket ticket : dataBase.tickets){
            count += 1;
        }

        System.out.println("amount of elements: " + count);
        return "";
    }

    @Override
    public String getCommandArguments() {
        return "";
    }
}
