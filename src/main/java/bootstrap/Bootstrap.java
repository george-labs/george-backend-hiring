package bootstrap;

import counter.WordCounter;
import io.ConsoleIO;
import io.IO;

import java.io.IOException;

public class Bootstrap {

    public void start() {
        IO consoleIo = new ConsoleIO();
        WordCounter wordCounter = new WordCounter();

        consoleIo.print("Enter text: ");

        try {
            String input = consoleIo.read();
            consoleIo.println("Number of words: " + wordCounter.count(input));
        } catch (IOException e) {
            consoleIo.println("Error: " + e.getMessage());
        }
    }
}
