package database;

import commands.CommandProcessor;
import commands.dataBaseCommands.*;
import package1.Coordinates;
import package1.Person;
import package1.Ticket;
import package1.TicketType;

import java.util.*;

public class DataBase {
    private final CommandProcessor commandProcessor;
    public ArrayDeque<Ticket> tickets = new ArrayDeque<Ticket>();
    public Set<Integer> ArrayOfUniqueID = new HashSet<Integer>();



    public DataBase(CommandProcessor commandProcessor){
        this.commandProcessor = commandProcessor;
        commandProcessor.getCommands().put("add", new AddCommand(this, commandProcessor));
        commandProcessor.getCommands().put("add_if_max", new AddIfMaxCommand(this, commandProcessor));
        commandProcessor.getCommands().put("add_if_min", new AddIfMinCommand(this, commandProcessor));
        commandProcessor.getCommands().put("clear", new ClearCommand(this));
        commandProcessor.getCommands().put("count_greater_than_price", new CountGreaterThanPriceCommand(this));
        commandProcessor.getCommands().put("filter_greater_than_comment", new FilterGreaterThanCommentCommand(this));
        commandProcessor.getCommands().put("info", new InfoCommand(this));
        commandProcessor.getCommands().put("print_field_descending_price", new PrintFieldDescendingPriceCommand(this));
        commandProcessor.getCommands().put("remove_by_id", new RemoveByIdCommand(this));
        commandProcessor.getCommands().put("remove_first", new RemoveFirstCommand(this));
        commandProcessor.getCommands().put("show", new ShowCommand(this));
        commandProcessor.getCommands().put("update_id", new UpdateIdCommand(this));
    }




    public static Ticket createNewTicket( int id,
                                        String name,
                                        Coordinates coordinates,
                                        Date creationDate,
                                        Long price,
                                        int discount,
                                        String comment,
                                        TicketType type,
                                        Person person){


        return new Ticket(id, name, coordinates, creationDate,
               price, discount,comment, type, person);

    }

    public int maxID(){
        List<Integer> IDs = new ArrayList();
        for(Ticket ticket : this.tickets){
            IDs.add(ticket.getId());
        }
       Collections.max(IDs);
        return Collections.max(IDs);

    }

    public int createID(){
        int newID = maxID() + 1;
        return newID;
    }

 }
