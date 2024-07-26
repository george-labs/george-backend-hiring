package sk.george.intervierw;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import sk.george.intervierw.io.input.ConsoleInputHandler;
import sk.george.intervierw.io.input.FileInputHandler;
import sk.george.intervierw.io.input.InputHandler;
import sk.george.intervierw.word_counter.WordCounter;
import sk.george.intervierw.word_counter.WordCounterFactory;

public class JavaApplication {
    private static final Logger LOGGER = Logger.getLogger(JavaApplication.class.getName());
    private static final InputHandler consoleInput = new ConsoleInputHandler(new Scanner(System.in));

    public static void main(String[] args) {
        // Initialize the word counter
        WordCounterFactory wordCounterFactory = new WordCounterFactory(new FileInputHandler());
        final WordCounter wordCounter = wordCounterFactory
                .createWithExcludedWords("/Users/adamlany/Documents/Code/george-backend-hiring/src/main/resources/word_counter/stopwords.txt");

        // Notify the user that input is needed
        LOGGER.log(Level.INFO,"Enter your input:");
        // Read the input
        String userInput = consoleInput.loadSingle(null);

        // Count the word
        final long wordCount = wordCounter.count(userInput);

        // Log the results to the user
        LOGGER.log(Level.INFO, String.format("Number of words: %d", wordCount));
    }
}
