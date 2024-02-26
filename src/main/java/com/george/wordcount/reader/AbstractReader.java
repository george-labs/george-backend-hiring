package com.george.wordcount.reader;

import com.george.wordcount.ContentReader;

public abstract class AbstractReader implements ContentReader {

    protected final String[] stopWords;

    protected AbstractReader(String[] stopWords) {
        this.stopWords = stopWords;
    }

}
