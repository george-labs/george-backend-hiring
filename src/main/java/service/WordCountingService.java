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
                .filter(word -> word.matches("[a-zA-Z]+"))
                .filter( word -> !stopWords.contains(word.toLowerCase()))
                .count();
    }

}
