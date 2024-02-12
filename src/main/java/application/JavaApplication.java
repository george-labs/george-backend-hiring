package application;

import io.ConsoleInputReader;
import io.ConsoleOutputWriter;
import io.InputReader;
import io.OutputWriter;
import processor.ItemProcessor;
import processor.Processor;
import validator.ConsoleInputValidator;
import validator.Validator;

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
        InputReader inputReader = new ConsoleInputReader();
        Validator validator = new ConsoleInputValidator(REGEX_ONLY_ALPHABET);
        Processor processor = new ItemProcessor(validator);

        messageWriter.write(List.of("Enter text: "));
        long result = processor.process(inputReader.readAndGetData());
        messageWriter.write(List.of("Number of words: ", Long.toString(result)));
    }

}
