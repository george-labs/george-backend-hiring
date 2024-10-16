package service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

    private final Set<String> stopWords;
    private static final String REGEX = "[a-zA-Z]+";
    private static final String WORD_SPLITTER = "\\s+";
    public WordCounter(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    public int countWords(String textInput) {
        if (isStringIsNotNullOrEmpty(textInput)) {
            return 0;
        }
        String[] words = textInput.split("\\s+");
        return (int) Stream.of(words)
                           .filter(word -> word.matches("[a-zA-Z]+"))
                           .map(String::toLowerCase)
                           .filter(word -> !stopWords.contains(word))
                           .count();
    }

    public int uniqueWordCounts(String textInput) {
        if (isStringIsNotNullOrEmpty(textInput)) {
            return 0;
        }
        String[] words = textInput.split(WORD_SPLITTER);
        Set<String> uniqueWords = Stream.of(words)
                                        .filter(word -> word.matches(REGEX))
                                        .map(String::toLowerCase)
                                        .filter(word -> !stopWords.contains(word))
                                        .collect(Collectors.toSet());

        return uniqueWords.size();
    }

    private boolean isStringIsNotNullOrEmpty(String textInput) {
        return textInput == null || textInput.isEmpty();
    }
}
