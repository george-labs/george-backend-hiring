package com.george.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class ConsoleReader {

    public static String readInput(Reader inputStreamReader) throws IOException {
        if (inputStreamReader == null) {
            throw new IOException("Can not read from reader");
        }
        System.out.print("Enter text: ");
        BufferedReader br = new BufferedReader(inputStreamReader);
        String line = br.readLine();

        return "Number of words: " + WordSplitter.countWords(line);
    }
}
