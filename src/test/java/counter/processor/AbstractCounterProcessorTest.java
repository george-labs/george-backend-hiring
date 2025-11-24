package counter.processor;

import counter.WordCounter;
import counter.WordCounterService;
import counter.filter.FileStopWordsFilter;
import counter.filter.StopWordsFilter;
import java.nio.file.Path;

public class AbstractCounterProcessorTest {
    protected WordCounter createTestWordCounter() {
        Path stopWordsFile = Path.of("src/test/resources/stopwords.txt");
        final StopWordsFilter wordsFilter = new FileStopWordsFilter(stopWordsFile);
        return new WordCounterService(wordsFilter);
    }
}
