package commands.dataBaseCommands;
import Interfaces.Executable;
import commands.absctractCommands.DataBaseCommand;
import database.DataBase;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ClearCommand extends DataBaseCommand implements Executable {
    final DataBase dataBase;

    public ClearCommand(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String ExecuteCommand(String... args)  {
        dataBase.tickets.clear();
        return "collection is clear!";
    }

    @Override
    public String getCommandArguments() {
        return "";
    }
}
