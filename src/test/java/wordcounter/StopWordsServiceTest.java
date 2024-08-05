package wordcounter;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopWordsServiceTest {

    private final StopWordsService stopWordsService = new StopWordsService("stopWords.txt", new FileReader());

    @Test
    void getStopWords_returnsStopWordsFromFile() {
        Set<String> stopWords = stopWordsService.getStopWords();

        assertEquals(Set.of("stopWord", "stopWord2"), stopWords);
    }
}
