package commands.fileCommands;
import Interfaces.Executable;
import commands.CommandProcessor;
import commands.absctractCommands.ProcessorsCommand;
import exceptions.CommandDoesntExists;
import lombok.EqualsAndHashCode;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class ExecuteScriptCommand extends ProcessorsCommand implements Executable {

    public ExecuteScriptCommand(CommandProcessor commandProcessor) {
        super(commandProcessor);
    }

    Stack<String> pathStack = new Stack<>();

    @Override
    public String ExecuteCommand(String... args) {
        if (args == null) {
            return "command expects argument. please try it one more time";
        }

        String scriptPath = Arrays.stream(args).map(word -> word + " ").collect(Collectors.joining()).trim();
        if(pathStack.contains(scriptPath)){
            return "recursion :(";
        }

        pathStack.push(scriptPath);

        try (Scanner scanner = new Scanner(new FileReader(scriptPath))){

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.isBlank()){
                    continue;
                }
                System.out.println(processor.executeCommand(line));
            }
            pathStack.pop();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (CommandDoesntExists e) {
            throw new RuntimeException(e);
        }

        return "done!";
    }

    @Override
    public String getCommandArguments() {
        return " {file_name}";
    }
}
