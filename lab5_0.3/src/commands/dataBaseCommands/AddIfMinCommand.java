package commands.dataBaseCommands;
import Interfaces.Executable;
import commands.CommandProcessor;
import commands.absctractCommands.DataBaseCommand;
import database.DataBase;
import lombok.EqualsAndHashCode;
import package1.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode
public class AddIfMinCommand extends DataBaseCommand implements Executable {

    final DataBase dataBase;
    final CommandProcessor commandProcessor;

    public AddIfMinCommand(DataBase dataBase, CommandProcessor commandProcessor) {
        this.dataBase = dataBase;
        this.commandProcessor = commandProcessor;
    }


    @Override
    public String ExecuteCommand(String... args) {

        try {
            if (args == null) {
                return "command expects argument. please try it one more time";
            }
            String price = args[0];
            List<Long> prices = new ArrayList();

            for (Ticket ticket : dataBase.tickets) {
                prices.add(ticket.getPrice());
            }


            if (Long.valueOf(price) >= Collections.min(prices)) {
                return "The price you entered is not the minimum element of the ticket collection, enter \"print_field_descending_price\" for view a price info ";
            }

            System.out.println("price you entered is lesser than min of prices, you can add a ticket: ");
            commandProcessor.getCommands().get("add").ExecuteCommand();
            return "done!";
        } catch (NumberFormatException e){
            return "argument should be a number, please try it one more time";

        }
    }





    @Override
    public String getCommandArguments(){
        return " {element}";
    }
}
