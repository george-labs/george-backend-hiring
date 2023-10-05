package bootstrap;

import counter.WordCounter;
import io.ConsoleIO;
import io.FileReader;

import java.io.IOException;

public class Bootstrap {

    public void start() {
        ConsoleIO consoleIo = new ConsoleIO(System.in);

        consoleIo.print("Enter text: ");

        try {
            FileReader fileReader = new FileReader("stopwords.txt");
            WordCounter wordCounter = new WordCounter(fileReader.read());

            String input = consoleIo.read();
            int wordCount = wordCounter.count(input);

            consoleIo.println("Number of words: " + wordCount);
        } catch (IOException e) {
            consoleIo.println("Error: " + e.getMessage());
        }
    }
}
