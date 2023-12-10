import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordFileReaderTest {
    @Test
    public void testLoadFileIntoListWithAValidFile() throws IOException {
        List<String> list = WordFileReader.loadFileIntoList("stopwords.txt");
        assertFalse(list.isEmpty());
        assertEquals(4, list.size());
    }

    @Test
    public void testLoadFileIntoListWithAnInvalidFile() {
        try {
            WordFileReader.loadFileIntoList("cats.txt");
            fail("Did not throw IOException");
        } catch (IOException e) {
            assertEquals("File Does not exist", e.getMessage());
        }
    }

    @Test
    public void testIsValidFileName() {
        String validFileName = "validfile.txt";
        String invalidFileName = "Invalid Fi(&le Name. txt";
        boolean valid = WordFileReader.isValidFileName(validFileName);
        boolean invalid = WordFileReader.isValidFileName(invalidFileName);
        assertTrue(valid);
        assertFalse(invalid);
    }
}
