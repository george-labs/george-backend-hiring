package sk.george.intervierw;

import java.util.Scanner;

import sk.george.intervierw.io.input.ConsoleInputHandler;
import sk.george.intervierw.io.input.FileInputHandler;
import sk.george.intervierw.io.output.SystemOutputHandler;
import sk.george.intervierw.word_counter.WordCounter;
import sk.george.intervierw.word_counter.WordCounterFactory;

public class JavaApplication {

    public static void main(String[] args) {
        // Extract the input file path from args
        final String inputFilePath = args.length > 0
                ? args[0]
                : null;

        // Create the new word counter with the excluded words
        WordCounterFactory wordCounterFactory = new WordCounterFactory(new FileInputHandler());
        WordCounter wordCounter = wordCounterFactory
                .createWithExcludedWords("/Users/adamlany/Documents/Code/george-backend-hiring/src/main/resources/word_counter/stopwords.txt");

        // Create the new application
        Application application = new Application(
                new ConsoleInputHandler(new Scanner(System.in)),
                new FileInputHandler(),
                new SystemOutputHandler(),
                wordCounter
        );

        // Run the application
        application.run(inputFilePath);
    }
}
