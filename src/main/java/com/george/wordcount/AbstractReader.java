package com.george.wordcount;

public abstract class AbstractReader implements ContentReader {

    protected final String[] stopWords;

    protected AbstractReader(String[] stopWords) {
        this.stopWords = stopWords;
    }

}
