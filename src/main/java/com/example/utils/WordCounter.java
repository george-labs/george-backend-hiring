package com.example.utils;

import java.util.Arrays;
import java.util.List;

public class WordCounter {
    public static int countWordsFilteringOutStopwords(String text) {
        return (int)Arrays.stream(text.split("\\s+"))
                .filter(WordCounter::isValidWord)
                .count();
    }

    public static int countWordsFilteringOutStopwords(String text, List<String> stopwords) {
        return (int)Arrays.stream(text.split("\\s+"))
                .filter(WordCounter::isValidWord)
                .filter(word -> filterStopwords(word, stopwords))
                .count();
    }

    private static boolean isValidWord(String word) {
        return word.matches("[a-zA-Z]+");
    }

    private static boolean filterStopwords(String word, List<String> stopwords) {
        return !stopwords.contains(word);
    }
}
