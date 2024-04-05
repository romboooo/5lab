package file;

import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import commands.*;
import commands.fileCommands.ExecuteScriptCommand;
import package1.*;
import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileProcessor {

    final CommandProcessor commandProcessor;
    
    public static final String CSVFILE = "/Users/rom4ikk/Desktop/учеба/1 курс/2 сем/прога/lab5_0.3/src/file/file.csv";
    Parser parser = new Parser();
    public FileProcessor(CommandProcessor commandProcessor){
        this.commandProcessor = commandProcessor;
        commandProcessor.getCommands().put("execute_script", new ExecuteScriptCommand(commandProcessor));
    }




    public static class Parser {

        public void writeToFile(List<Ticket> collection) {
            MappingStrategy<Ticket> strategy = new HeaderColumnNameMappingStrategy<>();

            strategy.setType(Ticket.class);


            try (FileWriter writer = new FileWriter(CSVFILE)) {
                new StatefulBeanToCsvBuilder(writer)
                        .withSeparator(';')
                        .withApplyQuotesToAll(false)
                        .withMappingStrategy(strategy)
                        .build()
                        .write(collection);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (CsvRequiredFieldEmptyException e) {
                throw new RuntimeException(e);
            } catch (CsvDataTypeMismatchException e) {
                throw new RuntimeException(e);
            }


        }
        public List<Ticket> readFromFile() throws IOException {
            try {
                FileReader reader = new FileReader(CSVFILE);
                List<Ticket> result = new CsvToBeanBuilder<Ticket>(reader)
                        .withType(Ticket.class)
                        .withSkipLines(0)
                        .withSeparator(';')
                        .withIgnoreQuotations(true)
                        .withThrowExceptions(false)


                        .build()
                        .parse();
                return result;
            }catch (RuntimeException e){
                System.err.println("wrong data! check file.csv");
                System.exit(0);
                return null;
            }
        }

    }
}
