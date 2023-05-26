import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {


    @Test
    void readFromFile_invalidPath() {
        String invalidPath = "invalid.path";
        Assertions.assertThrows(RuntimeException.class, () -> new TextProcessor().readFromFile(invalidPath));
    }

    @Test
    void readFromFile_validPath() {
        List<String> wordsFromFile = new TextProcessor().readFromFile("input.txt");
        List<String> expectedWordsFromFile = Arrays.asList("Mary had","a little", "lamb");
        Assertions.assertArrayEquals(expectedWordsFromFile.toArray(),wordsFromFile.toArray());
    }

    @Test
    void readFromConsole() {
        String input = "initialString";
        System.setIn( new ByteArrayInputStream(input.getBytes()));
        String inputString = new TextProcessor().readFromConsole();

        Assertions.assertEquals(input, inputString);
    }

    @Test
    void processText() {
    }
}