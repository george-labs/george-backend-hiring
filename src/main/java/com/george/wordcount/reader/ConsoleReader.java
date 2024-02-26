package com.george.wordcount.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class ConsoleReader extends AbstractReader {

    public ConsoleReader(Reader reader) throws IOException {
        super(reader);
    }

    protected String readInput(Reader inputStreamReader) throws IOException {
        System.out.print("Enter text: ");
        try {
            BufferedReader br = new BufferedReader(inputStreamReader);
            return br.readLine();
        } catch (NullPointerException e) {
            throw new IOException("Input stream is null");
        }
    }
}
