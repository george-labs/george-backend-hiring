import domain.entity.WordCountResult;

import java.util.*;
import java.util.regex.Pattern;

public class WordCounter {
    private final static String WHITESPACE_REGEX = "[\\s-\\.]";
    private final static String VALID_WORD_REGEX = "^([A-Za-z]+)$";
    private final static Pattern WORD_PATTERN = Pattern.compile(VALID_WORD_REGEX);

    private final List<String> stopWords;

    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public WordCounter() {
        this.stopWords = new ArrayList<>();
    }

    public WordCountResult getNumberOfWords(String text) {
        final List<String> wordList = Arrays.stream(text.split(WHITESPACE_REGEX)).toList();

        List<String> totalWordCount = wordList.stream()
                .filter(word -> !stopWords.contains(word))
                .filter(WORD_PATTERN.asPredicate())
                .toList();

        Set<String> uniqueWordsSet = new HashSet<>(totalWordCount);

        return new WordCountResult(totalWordCount.size(), uniqueWordsSet.size());
    }
}
