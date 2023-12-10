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
}
