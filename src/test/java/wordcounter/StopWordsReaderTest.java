package wordcounter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopWordsReaderTest {

    private final StopWordsReader stopWordsReader = new StopWordsReader("stopWords.txt");

    @Test
    void getStopWords_returnsStopWordsFromFile() {
        List<String> stopWords = stopWordsReader.getStopWords();

        assertEquals(List.of("stopWord", "stopWord2"), stopWords);
    }
}
