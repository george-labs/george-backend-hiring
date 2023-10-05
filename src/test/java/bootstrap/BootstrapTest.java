package bootstrap;

import counter.CounterResult;
import counter.WordCounter;
import handler.ConsoleInputHandler;
import handler.FileInputHandler;
import handler.InputHandler;
import io.Console;
import io.FileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BootstrapTest {

    @Test
    public void testApplicationFlowWithoutFile() {
        String inputText = "Mary had a little lamb lamb";

        InputHandler inputHandler = new ConsoleInputHandler(new Console(new ByteArrayInputStream(inputText.getBytes())));
        FileReader fileReader = new FileReader(",", "stopwords.txt");

        try {
            WordCounter wordCounter = new WordCounter(fileReader.read());
            Bootstrap bootstrap = new Bootstrap(wordCounter, inputHandler);

            CounterResult counterResult = bootstrap.count();
            Assertions.assertEquals(5, counterResult.getNumberOfWords(), "Word counter did not return the right amount of words.");
            Assertions.assertEquals(4, counterResult.getNumberOfUniqueWords(), "Word counter did not return the right amount of unique words.");
        } catch (IOException e) {
            Assertions.fail();
        }
    }

    @Test
    public void testApplicationFlowWithFile() {
        InputHandler inputHandler = new FileInputHandler(new FileReader(" ", "mytext.txt"));
        FileReader fileReader = new FileReader(",", "stopwords.txt");

        try {
            WordCounter wordCounter = new WordCounter(fileReader.read());
            Bootstrap bootstrap = new Bootstrap(wordCounter, inputHandler);

            CounterResult counterResult = bootstrap.count();
            Assertions.assertEquals(5, counterResult.getNumberOfWords(), "Word counter did not return the right amount of words.");
            Assertions.assertEquals(4, counterResult.getNumberOfUniqueWords(), "Word counter did not return the right amount of unique words.");
        } catch (IOException e) {
            Assertions.fail();
        }
    }
}
