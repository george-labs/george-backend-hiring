import bootstrap.Bootstrap;
import counter.WordCounter;
import handler.InputHandler;
import handler.InputHandlerFactory;
import io.FileReader;

import java.io.IOException;

public class JavaApplication {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader(",", "stopwords.txt");

        try {
            WordCounter wordCounter = new WordCounter(fileReader.read());
            InputHandler inputHandler = InputHandlerFactory.create(args);

            int wordCount = new Bootstrap(wordCounter, inputHandler).count();
            System.out.println("Number of words: " + wordCount);
        } catch (IOException e) {
            System.err.println("An error occurred while counting words. Message: " + e.getMessage());
        }
    }
}
