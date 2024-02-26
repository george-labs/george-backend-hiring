package com.george.wordcount.reader;

import com.george.wordcount.WordSplitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class ConsoleReader extends AbstractReader {

    public ConsoleReader(String[] stopWords) {
        super(stopWords);
    }

    public String readInput(Reader inputStreamReader) throws IOException {
        System.out.print("Enter text: ");
        try {
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line = br.readLine();
            return "Number of words: " + WordSplitter.countWords(line, stopWords);
        } catch (NullPointerException e) {
            throw new IOException("Input stream is null");
        }
    }
}
