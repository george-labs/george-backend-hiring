package com.george.wordcount;

import com.george.wordcount.reader.ConsoleReader;
import com.george.wordcount.reader.FileReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class WordCounterReader {
    private final StopWordsReader stopWordsReader;
    private final ContentReader reader;
    private final InputStreamReader inputStreamReader;

    public WordCounterReader(String[] args) throws IOException {
        stopWordsReader = new StopWordsReader("/stopwords.txt");
        if (args.length == 1) {
            reader = new FileReader(stopWordsReader.getWords());
            inputStreamReader = new InputStreamReader(StopWordsReader.class.getResourceAsStream("/" + args[0]));
        } else {
            reader = new ConsoleReader(stopWordsReader.getWords());
            inputStreamReader = new InputStreamReader(System.in);
        }
    }

    public String getResultString() throws IOException {
        return reader.readInput(inputStreamReader);
    }
}
