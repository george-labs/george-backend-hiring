package com.example.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WordCounter {
    public static int countWords(String text) {
        return (int)Arrays.stream(text.split("\\s+"))
                .filter(WordCounter::isValidWord)
                .count();
    }

    public static int countWords(String text, List<String> stopwords) {
        return (int)Arrays.stream(text.split("\\s+"))
                .filter((word) => isValidWord(word, stopwords))
                .count();
    }

    private static boolean isValidWord(String word) {
        return word.matches("[a-zA-Z]+");
    }

    private static boolean isValidWord(String word, List<String> stopwords) {
        return word.matches("[a-zA-Z]+");
    }
}
