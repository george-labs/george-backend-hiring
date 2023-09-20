import java.io.IOException;

import app.WhiteCharWordCounter;
import app.WordCounter;
import app.validation.InputValidator;
import input.ConsoleReader;
import output.ConsoleWriter;

public class JavaApplication {

    public static void main(String[] args) throws IOException {

        // CONF
        WordCounter wordCounter = new WhiteCharWordCounter();
        ConsoleReader consoleReader = new ConsoleReader();
        ConsoleWriter consoleWriter = new ConsoleWriter();
        InputValidator inputValidator = new InputValidator();

        // IN
        String inputLine = consoleReader.readLine();

        // APP
        inputValidator.validateInputLine(inputLine);
        long wordCount = wordCounter.countWords(inputLine);

        // OUT
        consoleWriter.writeWordCountOutput(wordCount);
    }

}
