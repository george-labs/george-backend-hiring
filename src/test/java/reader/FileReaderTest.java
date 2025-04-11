package reader;

import org.junit.jupiter.api.Test;
import service.reader.FileReader;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {

    private static final String STOPWORDS_FILE_NAME = "stopwords.txt";

    @Test
    void readStopWordsFile() {
        FileReader fileReader = new FileReader();
        assertFalse(fileReader.readInput(STOPWORDS_FILE_NAME).isBlank());
    }

    @Test
    void readFileWithError() {
        FileReader fileReader = new FileReader();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            fileReader.readInput(null);
        });

        assertTrue(exception.getMessage().contains("File could not be loaded"));
        assertInstanceOf(RuntimeException.class, exception);
    }
}
