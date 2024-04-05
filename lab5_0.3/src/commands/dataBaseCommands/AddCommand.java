package commands.dataBaseCommands;
import Interfaces.Executable;
import commands.CommandProcessor;
import commands.absctractCommands.DataBaseCommand;
import database.DataBase;
import exceptions.CommandDoesntExists;
import lombok.EqualsAndHashCode;
import package1.*;

import java.time.Instant;
import java.util.*;

@EqualsAndHashCode
public class AddCommand extends DataBaseCommand implements Executable {
    final DataBase dataBase;

    boolean IsAllDataEntered = false;

    final CommandProcessor commandProcessor;

    HashMap<String,String> ticketFields = new HashMap<>();
    String[] fields = new String[]{
            "name",
            "coordinates x",
            "coordinates y",
            "price",
            "discount",
            "comment",
            "type",
            "weight",
            "passportid",
            "locationname"

    };


    public AddCommand(DataBase dataBase, CommandProcessor commandProcessor) {
        this.dataBase = dataBase;
        this.commandProcessor = commandProcessor;
    }

    public void printEnteredValues() {
        ticketFields.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey()+": "+entry.getValue());
        });
    }
    private void enterData(Scanner scanner){

        enterName(scanner);
        enterX(scanner);
        enterY(scanner);
        enterPrice(scanner);
        enterDiscount(scanner);
        enterComment(scanner);
        enterType(scanner);
        enterWeight(scanner);
        enterPassportID(scanner);
        enterLocationName(scanner);
    }

    public void enterName(Scanner scanner){
        System.out.println("enter name:");
        String scannerName = scanner.nextLine();


        if (Ticket.Checker.checkName(scannerName)){
            String name = scannerName;
            System.out.println("done!");
            ticketFields.put("name", name);
            printEnteredValues();
        } else {
            System.out.println("name must not be empty");
            enterName(scanner);
        }
    }

    public void enterX(Scanner scanner){
        System.out.println("enter x");
        String scannerX = scanner.nextLine().strip();

        try {
            if (Ticket.Checker.checkX(Float.valueOf(scannerX))) {
                String x = scannerX;
                ticketFields.put("x", x);
                System.out.println("done!");
                printEnteredValues();
            } else {
                System.out.println("x must be a number and not null");
                enterX(scanner);
            }
        } catch(NumberFormatException e){
            System.out.println("x must be a number");
            System.out.println("also it must be bigger than -1001 and less than 1001");
            enterX(scanner);
        }
    }
    public void enterY(Scanner scanner){
        System.out.println("enter y");
        String scannerY = scanner.nextLine().strip();

        try {
            if (Ticket.Checker.checkY(Float.valueOf(scannerY))) {
                String y = scannerY;
                ticketFields.put("y", y);
                System.out.println("done!");
                printEnteredValues();
            } else {
                System.out.println("x coordinate must not be empty");
                enterY(scanner);
            }
        } catch (NumberFormatException e){
            System.out.println("y must be a number ");
            System.out.println("also it must be bigger than -1001 and less than 1001");
            enterY(scanner);
        }
    }
    public void enterPrice(Scanner scanner){
        System.out.println("enter price");
        String scannerPrice = scanner.nextLine().strip();

        try {
            if (Ticket.Checker.checkPrice(Long.valueOf(scannerPrice))) {
                Long price = Long.valueOf(scannerPrice);
                ticketFields.put("price", price.toString());
                System.out.println("done!");
                printEnteredValues();
            } else {
                System.out.println("price must be not empty and bigger than zero");
                enterPrice(scanner);
            }
        } catch (NumberFormatException e){
            System.out.println("price must be a number");
            enterPrice(scanner);
        }
    }

    public void enterDiscount(Scanner scanner){
         System.out.println("enter discount (it must be bigger than 0 and less than 101)");
         String scannerDiscount = scanner.nextLine().strip();

         try {
            if(Ticket.Checker.checkDiscount(Integer.parseInt(scannerDiscount))){
                int discount = Integer.parseInt(scannerDiscount);
                ticketFields.put("discount", String.valueOf(discount));
                System.out.println("done!");
                printEnteredValues();
            }
            else{
                System.out.println("discount must be bigger than 0 and less than 101!");
                enterDiscount(scanner);
            }
         } catch (NumberFormatException e){
             System.out.println("discount must be a number");
             System.out.println("also it must be bigger than 0 and less than 101");
             enterDiscount(scanner);
         }
    }


    public void enterComment(Scanner scanner){
        System.out.println("enter comment");
        String scannerComment = scanner.nextLine();
        if(Ticket.Checker.checkComment(scannerComment)){
            String comment = scannerComment;
            ticketFields.put("comment",comment);
            System.out.println("done!");
            printEnteredValues();
        }else {
            System.out.println("comment must not be empty");
            enterComment(scanner);
        }
    }

    public void enterType(Scanner scanner){

        System.out.println("enter type (you can write it in lower case)");
        System.out.println("VIP / USUAL / BUDGETARY / CHEAP");

        String scannerType = scanner.nextLine().strip().toUpperCase();
        if((scannerType.equals("VIP")) || (scannerType.equals("USUAL")) || (scannerType.equals("BUDGETARY")) || (scannerType.equals("CHEAP"))){
            String type = scannerType;
            ticketFields.put("type",type);
            System.out.println("done!");
            printEnteredValues();
        } else{
            System.out.println("enter valid type VIP / USUAL / BUDGETARY / CHEAP");
            enterType(scanner);
        }
    }

    public void enterWeight(Scanner scanner){
        System.out.println("enter weight of person");

        String scannerWeight = scanner.nextLine().strip();
        try{
            if (Integer.valueOf(scannerWeight) > 0){
                int weight = Integer.valueOf(scannerWeight);
                ticketFields.put("weight", String.valueOf(weight));
                System.out.println("done!");
                printEnteredValues();
            } else{
                System.out.println("weight must be bigger than 0");
                enterWeight(scanner);
            }
        } catch(NumberFormatException e){
            System.out.println("weight must be a number");
            enterWeight(scanner);
        }
    }


    public void enterPassportID(Scanner scanner){
        System.out.println("enter passportID");
        String scannerPassportID = scanner.nextLine().strip();

        if (scannerPassportID.length() >= 4){
            String passportID = scannerPassportID;
            ticketFields.put("passportID", passportID);
            System.out.println("done!");
            printEnteredValues();
        } else{
            System.out.println("passportID's lenght must be >= 4");
            enterPassportID(scanner);
        }
    }
    public void enterLocationName(Scanner scanner){
        System.out.println("enter location name");
        String scannerLocationName = scanner.nextLine();
        if(!scannerLocationName.isBlank()){
            String locationName = scannerLocationName;
            ticketFields.put("locationName",locationName);
            System.out.println("done!");
            printEnteredValues();
        } else{
            System.out.println("location name must not be empty");
            enterLocationName(scanner);
        }
    }



    @Override
    public String ExecuteCommand(String... args){

        Scanner scanner = new Scanner(System.in);

        enterData(scanner);

        Ticket ticket = dataBase.createNewTicket(
                dataBase.createID(), //id
                ticketFields.get("name"),                       // name
                new Coordinates(
                        Float.parseFloat(ticketFields.get("x")),
                        Float.parseFloat(ticketFields.get("y"))), //coord-s
                Date.from(Instant.now()),                           //дата
                Long.parseLong(ticketFields.get("price")),        //  price
                Integer.parseInt(ticketFields.get("discount")),  // discount
                ticketFields.get("comment"),                    // comment
                TicketType.valueOf(ticketFields.get("type")),   //type
                new Person(
                        java.time.LocalDateTime.now(),
                        Integer.parseInt(ticketFields.get("weight")),
                        ticketFields.get("passportID"),
                        new Location(
                                Integer.parseInt(ticketFields.get("x")),
                                Long.parseLong(ticketFields.get("y")),
                                (ticketFields.get("locationName"))
                        )
                )
        );

        dataBase.tickets.add(ticket);
        ticketFields.clear();

        System.out.println("ticket was created, don't forget to save it!");
        
        return "Type \"help\" for display available commands:";
    }

    @Override
    public String getCommandArguments() {
        return "";
    }
}
