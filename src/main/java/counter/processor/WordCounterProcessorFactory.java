package counter.processor;

import counter.WordCounter;
import counter.WordCounterService;
import counter.filter.FileStopWordsFilter;
import counter.filter.StopWordsFilter;
import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;

public class WordCounterProcessorFactory {
    public static WordCounterProcessor createProcessor(ProcessorType type) {
        if (type == null) {
            throw new IllegalArgumentException("Type Parameter is required");
        }
        switch (type) {
            case STRING -> {
                return createStringProcessor();
            }
            case FILE -> {
                return createFileProcessor();
            }
            default ->  throw new IllegalArgumentException("Unknown processor type " + type);
        }
    }

    private static WordCounterProcessor createStringProcessor() {
        final WordCounter wordCounter = createWordCounter();
        return new StringWordCounterProcessor(wordCounter);
    }

    private static WordCounterProcessor createFileProcessor() {
        final WordCounter wordCounter = createWordCounter();
        return new FileWordCounterProcessor(wordCounter);
    }

    @NotNull
    private static WordCounter createWordCounter() {
        Path stopWordsFile = Path.of("src/test/resources/stopwords.txt");
        final StopWordsFilter wordsFilter = new FileStopWordsFilter(stopWordsFile);
        return new WordCounterService(wordsFilter);
    }
}
