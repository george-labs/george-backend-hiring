package application;

import io.ConsoleInputReader;
import io.InputReader;
import processor.ItemProcessor;
import processor.Processor;
import validator.ConsoleInputValidator;
import validator.Validator;

public class JavaApplication {
    
    private final InputReader inputReader;
    private final Processor processor;
    private static final String REGEX_ONLY_ALPHABET = "^[a-zA-Z]+$";

    public JavaApplication(InputReader inputReader, Processor processor) {
        this.inputReader = inputReader;
        this.processor = processor;
    }

    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader();
        Validator validator = new ConsoleInputValidator(REGEX_ONLY_ALPHABET);
        Processor processor = new ItemProcessor(validator);

        

    }

}
