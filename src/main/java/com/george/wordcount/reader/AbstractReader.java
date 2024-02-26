package com.george.wordcount.reader;

import com.george.wordcount.ContentReader;

import java.io.IOException;
import java.io.Reader;

public abstract class AbstractReader implements ContentReader {

    protected final Reader reader;

    protected String content;

    protected AbstractReader(Reader reader) throws IOException {
        this.reader = reader;
        content = readInput(reader);
    }

    protected abstract String readInput(Reader inputStreamReader) throws IOException;

    @Override
    public String getContent() {
        return content;
    }
}
