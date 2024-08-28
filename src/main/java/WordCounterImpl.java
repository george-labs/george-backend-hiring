import java.util.List;

public class WordCounterImpl implements WordCounter {

    private SentenceReader sentenceReader;
    private WordFilter wordFilter;
    private WordSpliter wordSpliter;

    public WordCounterImpl(SentenceReader sentenceReader, WordFilter wordFilter,
                           WordSpliter wordSpliter) {
        this.sentenceReader = sentenceReader;
        this.wordSpliter = wordSpliter;
        this.wordFilter = wordFilter;
    }

    @Override
    public int countWords() {
        String[] splitedWords = wordSpliter.splitWordsBySpace(sentenceReader.readSentence());
        List<String> filteredWords = wordFilter.filterWords(splitedWords);

        return WordUtils.countWords(filteredWords);
    }

}
