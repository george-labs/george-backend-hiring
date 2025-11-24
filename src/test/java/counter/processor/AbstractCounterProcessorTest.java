package counter.processor;

import counter.WordCounter;
import counter.WordCounterService;
import counter.filter.FileStopWordsFilter;
import counter.filter.StopWordsFilter;
import counter.model.CountingResult;
import java.nio.file.Path;
import java.util.Locale;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractCounterProcessorTest {
    protected WordCounter createTestWordCounter() {
        Path stopWordsFile = Path.of("src/test/resources/stopwords.txt");
        final StopWordsFilter wordsFilter = new FileStopWordsFilter(stopWordsFile);
        return new WordCounterService(wordsFilter);
    }

    protected void assertCounterMessage(String actual, CountingResult expectedCountingResult) {
        assertCounterMessage(actual, expectedCountingResult, "Invalid output");
    }
    protected void assertCounterMessage(String actual, CountingResult expectedCountingResult, String message) {
        assertEquals(String.format(Locale.ENGLISH, "Number of words: %s, unique: %s; average word length: %.2f characters"
                , expectedCountingResult.getTotalWordsCount()
                , expectedCountingResult.getUniqueWordsCount()
                , expectedCountingResult.getAvgWordLength())
                , actual
                , message);
    }
}
