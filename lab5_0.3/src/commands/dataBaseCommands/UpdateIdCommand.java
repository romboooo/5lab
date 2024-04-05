package commands.dataBaseCommands;
import Interfaces.Executable;
import commands.absctractCommands.DataBaseCommand;
import database.DataBase;
import lombok.EqualsAndHashCode;
import package1.Ticket;

@EqualsAndHashCode
public class UpdateIdCommand extends DataBaseCommand implements Executable {

    final DataBase dataBase;




    public UpdateIdCommand(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String ExecuteCommand(String... args)  {
        try {
            if (args == null) {
                return "command expects argument. please try it one more time";
            }
            if (args.length != 2) {
                return "command expends 2 arguments";
            }

            int oldID = Integer.parseInt(args[0]);
            int newID = Integer.parseInt(args[1]);
            boolean isOldIDExists = false;
            boolean isNewIDIsAlreadyUsed = false;
            Ticket oldTicket = null;

            for (Ticket ticket : dataBase.tickets) {
                if (ticket.getId() == oldID) {
                    isOldIDExists = true;
                    oldTicket = ticket;
                    break;
                }
            }

            if (!isOldIDExists) {
                return "sorry,there is no ticket with id: " + oldID;
            }


            for (Ticket tickett : dataBase.tickets) {
                if (newID == tickett.getId()) {
                    isNewIDIsAlreadyUsed = true;
                    break;
                }
            }
            if (isNewIDIsAlreadyUsed) {
                return "id " + newID + " is already used";
            }

            oldTicket.setId(newID);
            return "done!";
        }catch (NumberFormatException e){
            return "argument should be a number. please, try it one more time";
        }
    }




    @Override
    public String getCommandArguments() {
        return " {oldID} {newID}";
    }
}
