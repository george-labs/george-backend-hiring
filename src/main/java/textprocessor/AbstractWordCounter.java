package textprocessor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AbstractWordCounter {
    private StopWordsChecker stopWordsChecker;

    public AbstractWordCounter(StopWordsChecker stopWordsChecker) {
        this.stopWordsChecker = stopWordsChecker;
    }

    protected WordsCount countWordsUnique(String text) {
        Set<String> uniqueWords = new HashSet<>();

        String[] allWords = text.split("[\\s-.]+");
        List<String> realWords = Arrays.stream(allWords)
                .filter(word -> word.matches("[A-Za-z]+"))
                .map(String::toLowerCase)
                .filter(word -> !stopWordsChecker.isStopWord(word))
                .collect(Collectors.toList());

        return new WordsCount(realWords.size(), new HashSet<>(realWords).size());
    }
}
