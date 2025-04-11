package util.reader;

import org.junit.jupiter.api.Test;
import util.reader.FileReader;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {

    private static final String STOPWORDS_FILE_NAME = "stopwords.txt";

    @Test
    void readStopWordsFile() {
        FileReader fileReader = new FileReader();
        String text = fileReader.readInput(STOPWORDS_FILE_NAME);
        assertEquals("the a off on", text);
    }


    //TODO: fix the test
    @Test
    void readFileWithError() {
        FileReader fileReader = new FileReader();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            fileReader.readInput("abc.txt");
        });

        assertTrue(exception.getMessage().contains("File could not be loaded"));
        assertInstanceOf(RuntimeException.class, exception);
    }
}
