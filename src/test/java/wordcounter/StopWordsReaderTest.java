package wordcounter;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopWordsReaderTest {

    private final StopWordsReader stopWordsReader = new StopWordsReader("stopWords.txt");

    @Test
    void getStopWords_returnsStopWordsFromFile() {
        Set<String> stopWords = stopWordsReader.getStopWords();

        assertEquals(Set.of("stopWord", "stopWord2"), stopWords);
    }
}
