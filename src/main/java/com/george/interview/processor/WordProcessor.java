package com.george.interview.processor;

import com.george.interview.counter.Counter;
import com.george.interview.counter.WordCounter;
import com.george.interview.file.FileReader;
import com.george.interview.file.FileUtils;
import com.george.interview.file.LocalSystemFileReader;

import java.util.List;

public class WordProcessor implements Processor{
    @Override
    public void process(String input) {
        Counter counter = new WordCounter();
        FileReader fileReader = new LocalSystemFileReader();
        List<String> excludedWords = FileUtils.getFileLines(fileReader.read("/stopwords.txt"));
        System.out.println("Number of words: " + counter.count(input, excludedWords));
    }
}
