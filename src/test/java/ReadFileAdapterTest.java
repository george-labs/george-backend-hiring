import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadFileAdapterTest {

    @Test
    public void testLoadTextFromFile() {
        String text = ReadFileAdapter.loadTextFromFile("mytext.txt");
        assertEquals(text, "Mary had a little lamb");
    }

    @Test
    public void testGetStopWords() {
        Set<String> stopWords = ReadFileAdapter.getStopWords();
        assertEquals(stopWords.size(), 4);
        assertTrue(stopWords.contains("the"));
        assertTrue(stopWords.contains("a"));
        assertTrue(stopWords.contains("on"));
        assertTrue(stopWords.contains("off"));


    }

}
