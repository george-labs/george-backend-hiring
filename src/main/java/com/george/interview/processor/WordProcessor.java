package com.george.interview.processor;

import com.george.interview.counter.Counter;
import com.george.interview.counter.CounterResultData;
import com.george.interview.file.FileReader;
import com.george.interview.file.FileUtils;
import com.george.interview.handler.InputData;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

public class WordProcessor implements Processor {

    private static final String STOP_WORDS_FILE = "stopwords.txt";

    private FileReader fileReader;
    private Counter counter;

    public WordProcessor(FileReader fileReader, Counter counter) {
        this.fileReader = fileReader;
        this.counter = counter;

    }

    @Override
    public void process(InputData input) {
        List<String> excludedWords = Collections.emptyList();
        try {
            excludedWords = FileUtils.getFileLines(fileReader.read(STOP_WORDS_FILE));
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error reading excluded word: " + e.getMessage());
        }
        CounterResultData result = counter.count(input.getWordInput(), excludedWords, input.isIndexTableAllowed());
        StringBuilder resultPrint = new StringBuilder()
                .append("Number of words: ")
                .append(result.getCount())
                .append(", unique: ").append(result.getCountUnique())
                .append(", average word length: ")
                .append(String.format("%.2f", result.getAverageWordLength()))
                .append(" characters");
        appedIndexTable(input.isIndexTableAllowed(), result, resultPrint);
        System.out.println(resultPrint);
    }

    private void appedIndexTable(boolean indexTableAllowed, CounterResultData result, StringBuilder resultPrint) {
        if (indexTableAllowed) {
            resultPrint.append("\nIndex table: ");
            result.getIndexTable().forEach((value) ->
                    resultPrint
                            .append("\n")
                            .append(value)
            );
        }
    }
}
