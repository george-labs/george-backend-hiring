import bootstrap.Bootstrap;
import counter.CounterResult;
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

            CounterResult counterResult = new Bootstrap(wordCounter, inputHandler).count();
            System.out.println("Number of words: " + counterResult.getNumberOfWords() + ", unique: " + counterResult.getNumberOfUniqueWords());
        } catch (IOException e) {
            System.err.println("An error occurred while counting words. Message: " + e.getMessage());
        }
    }
}
