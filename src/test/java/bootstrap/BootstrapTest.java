package bootstrap;

import counter.WordCounter;
import io.ConsoleIO;
import io.IO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BootstrapTest {

    @Test
    public void testApplicationFlow() {
        String inputText = "Mary had a little lamb";

        IO consoleIo = new ConsoleIO(new ByteArrayInputStream(inputText.getBytes()));
        WordCounter wordCounter = new WordCounter();

        try {
            String readText = consoleIo.read();
            Assertions.assertEquals(inputText, readText, "ConsoleIO read did not return the right text.");

            int numberOfWords = wordCounter.count(readText);
            Assertions.assertEquals(5, numberOfWords, "Word counter did not return the right amount of words.");
        } catch (IOException e) {
            Assertions.fail();
        }
    }
}
