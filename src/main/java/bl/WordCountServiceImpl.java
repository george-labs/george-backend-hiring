package bl;

import java.util.Arrays;
import java.util.Set;

public class WordCountServiceImpl implements WordCountService {

    private final StopWordsProvider stopWordsProvider;

    public WordCountServiceImpl(StopWordsProvider stopWordsProvider) {
        this.stopWordsProvider = stopWordsProvider;
    }

    @Override
    public long countWords(String input) {
        if (input == null) {
            return 0;
        }

        Set<String> stopWords = stopWordsProvider.getStopWords();

        String[] wordCandidates = input.split("\\s+");
        return Arrays.stream(wordCandidates)
                .filter(candidate -> candidate.matches("[a-zA-Z]+"))
                .filter(candidate -> !stopWords.contains(candidate))
                .count();
    }
}
