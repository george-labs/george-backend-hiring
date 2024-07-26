package sk.george.intervierw;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import sk.george.intervierw.io.input.ConsoleInputHandler;
import sk.george.intervierw.io.input.FileInputHandler;
import sk.george.intervierw.io.input.InputHandler;
import sk.george.intervierw.word_counter.WordCounter;
import sk.george.intervierw.word_counter.WordCounterFactory;

public class JavaApplication {
    private static final String EXCLUDED_WORDS_FILE_PATH = "/Users/adamlany/Documents/Code/george-backend-hiring/src/main/resources/word_counter/stopwords.txt";
    private static final Logger LOGGER = Logger.getLogger(JavaApplication.class.getName());
    private static final InputHandler CONSOLE_INPUT = new ConsoleInputHandler(new Scanner(System.in));
    private static final InputHandler FILE_INPUT = new FileInputHandler();

    public static void main(String[] args) {
        // Extract the input file path from args
        final String inputFilePath = args.length > 0
                ? args[0]
                : null;

        // Initialize the word counter
        WordCounterFactory wordCounterFactory = new WordCounterFactory(new FileInputHandler());
        final WordCounter wordCounter = wordCounterFactory
                .createWithExcludedWords(EXCLUDED_WORDS_FILE_PATH);

        long wordCount;
        if (Objects.nonNull(inputFilePath)) {
            // Read the file input
            List<String> texts = FILE_INPUT.loadMultiple(args[0]);
            // Count the word from the single input
            wordCount = wordCounter.count(texts);
        } else {
            // If there is no input provided, ask for the user to input
            LOGGER.log(Level.INFO,"Enter your input:");
            // Read the user's input
            final String userInput = CONSOLE_INPUT.loadSingle(null);
            // Count the word from the single input
            wordCount = wordCounter.count(userInput);
        }

        // Log the results to the user
        LOGGER.log(Level.INFO, String.format("Number of words: %d", wordCount));
    }
}
