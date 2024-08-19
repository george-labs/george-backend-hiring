package com.geogre.wordcount;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class WordCountApplication {

    private static final String SEPARATOR = " ";
    private static final String STOPWORDS_PATH = "/stopwords.txt";

    public static void main(String[] args) {
        configureWordCount().start();
    }

    private static WordCount configureWordCount() {
        WordCounter wordCounter = new WordCounter(SEPARATOR, getStopWords());
        return new WordCount(wordCounter);
    }

    private static @NotNull List<String> getStopWords() {
        InputStream inputStream = WordCountApplication.class.getResourceAsStream(STOPWORDS_PATH);
        if (inputStream == null) {
            throw new IllegalStateException("Stopwords config is not found");
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedReader.lines().toList();
    }
}