package service;

import java.util.Arrays;
import java.util.Set;

public class WordCountingService {

    private final StopWordsService stopWordsService;

    public WordCountingService(StopWordsService stopWordsService) {
        this.stopWordsService = stopWordsService;
    }


    public long countWords(String text) {
        if(text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        var stopWords = stopWordsService.getStopWords(text);
        if(stopWords == null) {
            throw new IllegalArgumentException("Stop words cannot be null");
        }
        var words = text.split("\\s+");
        return Arrays.stream(words)
                .map(this::removeTrailingDot)
                .filter(word -> word.matches("[a-zA-Z]+"))
                .filter( word -> !stopWords.contains(word.toLowerCase()))
                .count();
    }

    private String removeTrailingDot(String word) {
        if(word.endsWith(".")) {
            return word.substring(0, word.length() - 1);
        } else {
            return word;
        }
    }

}
