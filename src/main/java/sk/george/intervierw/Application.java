package sk.george.intervierw;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import sk.george.intervierw.io.input.InputHandler;
import sk.george.intervierw.io.output.OutputHandler;
import sk.george.intervierw.word_counter.WordCounter;

/**
 * Class representing the main application
 */
public class Application {
    private final Logger logger = Logger.getLogger(Application.class.getName());
    private final InputHandler consoleInput;
    private final InputHandler fileInput;
    private final OutputHandler outputHandler;
    private final WordCounter wordCounter;

    public Application(
            InputHandler consoleInput,
            InputHandler fileInput,
            OutputHandler outputHandler,
            WordCounter wordCounter
    ) {
        this.consoleInput = consoleInput;
        this.fileInput = fileInput;
        this.outputHandler = outputHandler;
        this.wordCounter = wordCounter;
    }

    /**
     * Run the application based on the provided input for the input file
     * @param input full path to the input file, or null for user input
     */
    public void run(String input) {
        long wordCount;
        if (Objects.nonNull(input)) {
            // Read the file input
            List<String> texts = fileInput.loadMultiple(input);
            // Count the word from the single input
            wordCount = wordCounter.count(texts);
        } else {
            // If there is no input provided, ask for the user to input
            outputHandler.print("Enter your input:");
            // Read the user's input
            final String userInput = consoleInput.loadSingle(null);
            // Count the word from the single input
            wordCount = wordCounter.count(userInput);
        }

        // Log the results to the user
        outputHandler.print(String.format("Number of words: %d", wordCount));
    }
}
