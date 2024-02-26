package com.george.wordcount.reader;

import com.george.wordcount.ContentReader;
import com.george.wordcount.WordCounter;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public abstract class AbstractReader implements ContentReader {

    protected final String[] stopWords;

    protected AbstractReader(String[] stopWords) {
        this.stopWords = stopWords;
    }

    @NotNull
    protected String getResultString(String line) {
        WordCounter wordCounter = new WordCounter(line, stopWords);
        return String.format("Number of words: %s, unique: %s; average word length: %s characters",
                wordCounter.getCount(), wordCounter.getUniqueCount(),
                String.format(Locale.US, "%.2f", wordCounter.getAverageWordLength()));
    }
}
