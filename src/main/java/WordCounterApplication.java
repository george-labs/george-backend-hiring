import stopwords.StopWordsReader;
import stopwords.StopWordsReaderConfiguration;
import stopwords.StopWordsReaderImpl;
import wordcounter.WordCounter;
import wordcounter.WordCounterImpl;
import wordcounter.WordCounterService;
import wordcounter.WordCounterServiceImpl;

public class WordCounterApplication {

    private static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) {
        final StopWordsReader stopWordsReader = createStopWordsReader();

        final WordCounter wordCounter = new WordCounterImpl();

        final WordCounterService wordCounterService = new WordCounterServiceImpl(wordCounter, stopWordsReader);

        wordCounterService.countWords();
    }

    private static StopWordsReader createStopWordsReader() {
        final StopWordsReaderConfiguration stopWordsReaderConfiguration =
                new StopWordsReaderConfiguration(STOP_WORDS_FILE_NAME);

        return new StopWordsReaderImpl(stopWordsReaderConfiguration);
    }
}
