package application;

import filter.Filter;
import filter.RegexFilter;
import filter.StopWordsFilter;
import io.*;
import processor.ItemProcessor;
import processor.Processor;
import validator.ConsoleInputValidator;
import validator.FileInputValidator;
import validator.Validator;

import java.nio.file.Paths;
import java.util.List;

public class JavaApplication {
    
    private final InputReader inputReader;
    private final Processor processor;
    private static final String REGEX_ONLY_ALPHABET = "^[a-zA-Z]+$";

    public JavaApplication(InputReader inputReader, Processor processor) {
        this.inputReader = inputReader;
        this.processor = processor;
    }

    public static void main(String[] args) {
        OutputWriter messageWriter = new ConsoleOutputWriter();
        // reading from file
        InputReader fileInputReader = new FileInputReader(Paths.get("src", "main", "resources").toString());
        List<String> stopWords = fileInputReader.readAndGetData();

        // read from console
        InputReader inputReader = new ConsoleInputReader();
        List<String> inputWords = inputReader.readAndGetData();
        
        // filter for alphabetical
        Validator regexValidator = new ConsoleInputValidator(REGEX_ONLY_ALPHABET);
        Filter regexFilter = new RegexFilter(regexValidator);

        // filter for stop words
        Validator fileValidator = new FileInputValidator(fileInputReader.readAndGetData());
        Filter stopWordsFilter = new StopWordsFilter(fileValidator);
        
        // counting
        Processor processor = new ItemProcessor(regexValidator);

        // printing

        messageWriter.write(List.of("Enter text: "));
        long result = processor.process(inputReader.readAndGetData());
        messageWriter.write(List.of("Number of words: ", Long.toString(result)));
    }

}
