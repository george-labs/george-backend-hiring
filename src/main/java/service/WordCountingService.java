package service;

import data.WordCountResult;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCountingService {

    private final StopWordsService stopWordsService;

    public WordCountingService(StopWordsService stopWordsService) {
        this.stopWordsService = stopWordsService;
    }

    public WordCountResult countWords(String text) {
        if(text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        var stopWords = stopWordsService.getStopWords(text);
        if(stopWords == null) {
            throw new IllegalArgumentException("Stop words cannot be null");
        }

        var words = text.split("\\s+");
        var validWords = Arrays.stream(words)
                .map(this::removeTrailingDot)
                .filter(word -> word.matches("[a-zA-Z\\-]+"))
                .filter( word -> !stopWords.contains(word.toLowerCase()))
                .toList();
        var uniqueWords = new HashSet<>(validWords);
        float averageWordLength;
        if (validWords.isEmpty()) {
            averageWordLength = 0;
        } else {
            averageWordLength  = (float) validWords.stream().map(String::length).mapToInt(Integer::intValue).sum() / validWords.size();
        }

        return new WordCountResult(validWords.size(), uniqueWords.size(), averageWordLength);
    }

    private String removeTrailingDot(String word) {
        if(word.endsWith(".")) {
            return word.substring(0, word.length() - 1);
        } else {
            return word;
        }
    }

}
