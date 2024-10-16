package service;

import java.util.Set;
import java.util.stream.Stream;

public class WordCounter {

    private final Set<String> stopWords;

    public WordCounter(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    public int countWords(String textInput) {
        if (textInput == null || textInput.isEmpty()) {
            return 0;
        }
        String[] words = textInput.split("\\s+");
        return (int) Stream.of(words)
                           .filter(word -> word.matches("[a-zA-Z]+"))
                           .map(String::toLowerCase)
                           .filter(word -> !stopWords.contains(word))
                           .count();
    }

}
