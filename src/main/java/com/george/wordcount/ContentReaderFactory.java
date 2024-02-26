package com.george.wordcount;

import com.george.wordcount.reader.ConsoleReader;
import com.george.wordcount.reader.FileReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class ContentReaderFactory {
    public ContentReader getContentReader(String[] args) throws IOException {
        if (args.length == 1) {
            return new FileReader(new InputStreamReader(StopWordsReader.class.getResourceAsStream("/" + args[0])));
        } else {
            return new ConsoleReader(new InputStreamReader(System.in));
        }
    }
}
