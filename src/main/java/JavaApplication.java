import java.io.IOException;

import app.WhiteCharWordCounter;
import app.WordCounter;
import input.ConsoleReader;
import output.ConsoleWriter;

public class JavaApplication {

    public static void main(String[] args) throws IOException {

        // CONF
        WordCounter wordCounter = new WhiteCharWordCounter();
        ConsoleReader consoleReader = new ConsoleReader();
        ConsoleWriter consoleWriter = new ConsoleWriter();

        // IN
        String inputLine = consoleReader.readLine();

        // APP
        int wordCount = wordCounter.countWords(inputLine);

        // OUT
        consoleWriter.writeWordCountOutput(wordCount);
    }

}
