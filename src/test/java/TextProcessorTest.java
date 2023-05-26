import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class TextProcessorTest {


    @Test
    void readFromConsole() {
        String input = "initialString";
        System.setIn( new ByteArrayInputStream(input.getBytes()));
        String inputString = new TextProcessor(new FileProcessor()).readFromConsole();

        Assertions.assertEquals(input, inputString);
    }

    @Test
    void processText() {
    }
}