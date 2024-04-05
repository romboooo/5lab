package commands.dataBaseCommands;
import Interfaces.Executable;
import commands.absctractCommands.DataBaseCommand;
import database.DataBase;
import exceptions.CommandException;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class RemoveFirstCommand extends DataBaseCommand implements Executable {
    final DataBase dataBase;

    public RemoveFirstCommand(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public String ExecuteCommand(String... args)  {

        dataBase.tickets.removeFirst();
        return "done!";
    }

    @Override
    public String getCommandArguments() {
        return "";
    }
}
