package com.george.wordcount.reader;

import com.george.wordcount.ContentReader;
import com.george.wordcount.WordSplitter;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractReader implements ContentReader {

    protected final String[] stopWords;

    protected AbstractReader(String[] stopWords) {
        this.stopWords = stopWords;
    }

    @NotNull
    protected String getResultString(String line) {
        WordSplitter wordSplitter = new WordSplitter(line, stopWords);
        return "Number of words: " + wordSplitter.getCount() + ", unique: " + wordSplitter.getUniqueCount();
    }
}
