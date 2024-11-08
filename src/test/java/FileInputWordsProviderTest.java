import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileInputWordsProviderTest {

    @Test
    public void testExampleWordsFileInput() throws Exception {
        List<String> result = new FileInputWordsProvider("target/test-classes/example.txt").provideWords();

        assertEquals(5, result.size());
        assertTrue(result.contains("Mary"));
    }
}
