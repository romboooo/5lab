package console;

import commands.CommandProcessor;
import commands.consoleCommands.ExitCommand;
import exceptions.CommandDoesntExists;
import lombok.Data;

import java.util.NoSuchElementException;
import java.util.Scanner;
@Data
public class ConsoleProcessor {

    private final CommandProcessor commandProcessor;

    public ConsoleProcessor(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;

        commandProcessor.getCommands().put("exit", new ExitCommand(this));
    }


    public void consoleExecute(){

            System.out.println("Type \"help\" for display available commands:");
            Scanner scanner = new Scanner(System.in);
            try {
                while (true) {
                    String input = scanner.nextLine();
                    try {
                        System.out.println(commandProcessor.executeCommand(input));
                    } catch (CommandDoesntExists e) {
                        System.err.println(e.getMessage());
                    }

                }
            } catch (NoSuchElementException e){
                System.err.println("консоль остановлена");
            }
        }
    }

