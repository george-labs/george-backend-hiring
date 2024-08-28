
import java.util.List;

public class WordCounterImpl implements WordCounter {

    private final SentenceReader sentenceReader;
    private final WordFilter wordFilter;
    private final WordSpliter wordSpliter;

    public WordCounterImpl(SentenceReader sentenceReader,
                           WordFilter wordFilter,
                           WordSpliter wordSpliter) {
        this.sentenceReader = sentenceReader;
        this.wordSpliter = wordSpliter;
        this.wordFilter = wordFilter;
    }

    @Override
    public int countWords() {
        List<String> stopWords = sentenceReader.readWordsFromFile("/stopwords.txt");
        String input = sentenceReader.readSentence();
        String[] splitedWords = wordSpliter.splitWordsBySpace(input);
        List<String> filteredWords = wordFilter.filterWords(splitedWords, stopWords);
        return WordUtils.countWords(filteredWords);
    }

}
