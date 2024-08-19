package com.geogre.wordcount;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WordCountApplication {

    private static final String SEPARATOR = " ";

    public static void main(String[] args) {
        configureWordCount().start();
    }

    private static WordCount configureWordCount() {
        WordCounter wordCounter = new WordCounter(SEPARATOR, getStopWords());
        return new WordCount(wordCounter);
    }

    private static @NotNull List<String> getStopWords() {
        return List.of("the", "a", "of", "on");
    }
}