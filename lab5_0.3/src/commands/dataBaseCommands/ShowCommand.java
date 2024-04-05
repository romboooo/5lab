package commands.dataBaseCommands;

import Interfaces.Executable;
import commands.absctractCommands.DataBaseCommand;
import database.DataBase;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

import java.util.stream.Collectors;

@EqualsAndHashCode
public class ShowCommand extends DataBaseCommand implements Executable {

    final DataBase dataBase;

    public ShowCommand(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @SneakyThrows
    @Override
    public String ExecuteCommand(String... args)  {
        System.out.println("if you don't see your ticket, check data in file.csv");
        return dataBase.tickets.stream().map(ticket ->
            ticket.toString() + "\n"
        ).collect(Collectors.joining());


    }

    @Override
    public String getCommandArguments() {
        return "";
    }
}
