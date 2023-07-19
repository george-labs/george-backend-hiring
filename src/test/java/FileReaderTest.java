import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {

    public static final String TEST_FILE = "src/test/resources/testFile.txt";
    FileReader fileReader = new FileReader();

    @Test
    public void testReadWordsFromFile() {
        List<String> result = fileReader.readWordsFromFile(TEST_FILE);

        assertFalse(result.isEmpty());
        assertEquals(8, result.size());
        assertTrue(result.containsAll(Arrays.asList("Mary", "had", "a", "little", "lamb.", "The", "other", "sentence.")));
    }

    @Test
    public void testReadWordsFromFile_fileNotFound() {
        List<String> result = fileReader.readWordsFromFile("incorrectTextFile.txt");

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetSentenceFromFile() {
        String result = fileReader.getSentenceFromFile(TEST_FILE);

        assertFalse(result.isEmpty());
        assertEquals("Mary had a little lamb. The other sentence.", result);
    }
}
