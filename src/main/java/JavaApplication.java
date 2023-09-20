import java.io.IOException;

import app.*;
import app.validation.InputValidator;
import config.IgnoredWordsReader;
import input.ConsoleReader;
import input.InputReader;
import output.ConsoleWriter;
import output.OutputWriter;

public class JavaApplication {

    public static void main(String[] args) throws IOException {
        // CONF
        InputReader consoleReader = new ConsoleReader();
        OutputWriter consoleWriter = new ConsoleWriter();
        InputValidator inputValidator = new InputValidator();
        IgnoredWordsReader ignoreWordsReader = new IgnoredWordsReader();
        WordCounter wordCounter = new FilteredWordCounter(ignoreWordsReader.readIgnoredWords());

        new WordCountApp(consoleReader, consoleWriter, inputValidator, wordCounter)
                .run();
    }

}
