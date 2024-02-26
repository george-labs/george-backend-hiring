package com.george.wordcount;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Locale;

public class ResultFormatter {

    @NotNull
    public static String getResultString(String content) throws IOException {
        StopWordsReader stopWordsReader = new StopWordsReader("/stopwords.txt");
        WordCounter wordCounter = new WordCounter(content, stopWordsReader.getWords());
        return String.format("Number of words: %s, unique: %s; average word length: %s characters",
                wordCounter.getCount(), wordCounter.getUniqueCount(),
                String.format(Locale.US, "%.2f", wordCounter.getAverageWordLength()));
    }
}
