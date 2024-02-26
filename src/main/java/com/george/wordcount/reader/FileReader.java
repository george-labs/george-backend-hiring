package com.george.wordcount.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class FileReader extends AbstractReader {

    public FileReader(Reader reader) throws IOException {
        super(reader);
    }

    protected String readInput(Reader inputStreamReader) throws IOException {
        if (inputStreamReader == null) {
            throw new IOException("Can not read from reader");
        }
        BufferedReader br = new BufferedReader(inputStreamReader);
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = br.readLine()) != null) {
            result.append(line).append('\n');
        }
        return result.toString();
    }
}
