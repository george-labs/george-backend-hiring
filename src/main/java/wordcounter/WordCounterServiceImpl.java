package wordcounter;

import stopwords.StopWordsReader;

import java.util.Set;

public class WordCounterServiceImpl implements WordCounterService {

    private static final String NUMBER_OF_WORDS_TEMPLATE = "Number of words: %s";

    private final WordCounter wordCounter;
    private final StopWordsReader stopWordsReader;

    public WordCounterServiceImpl(final WordCounter wordCounter,
                                  final StopWordsReader stopWordsReader) {
        this.wordCounter = wordCounter;
        this.stopWordsReader = stopWordsReader;
    }

    @Override
    public void countWords(final String userInput) {
        final Set<String> stopWords = stopWordsReader.getStopWordsList();

        final long wordCounts = wordCounter.countWords(userInput, stopWords);

        printWordCountsToConsole(wordCounts);
    }

    private static void printWordCountsToConsole(final long wordCounts) {
        System.out.println(String.format(NUMBER_OF_WORDS_TEMPLATE, wordCounts));
    }

}
