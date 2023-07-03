import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StopWordReaderTest {

    @Test
    public void testReading() throws IOException {
        StopWordReader stopWordReader = new StopWordReader();
        Set<String> stopWords = stopWordReader.readStopWordsFromFile("src/test/resources/stopWordFiles/stopwords.txt");
        assertTrue(stopWords.contains("the"));
        assertFalse(stopWords.contains("house"));
    }

}
