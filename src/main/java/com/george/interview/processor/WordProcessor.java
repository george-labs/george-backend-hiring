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
        CounterResultData result = counter.count(
                input.getWordInput(),
                excludedWords,
                input.isIndexTableAllowed(),
                input.getDictionaryWords()
        );
        printResultOfProcessing(result, input);
    }

    private void printResultOfProcessing(CounterResultData result, InputData input) {
        StringBuilder resultPrint = new StringBuilder()
                .append("Number of words: ")
                .append(result.getCount())
                .append(", unique: ").append(result.getCountUnique())
                .append(", average word length: ")
                .append(String.format("%.2f", result.getAverageWordLength()))
                .append(" characters");
        appendIndexTable(result, resultPrint, input.isIndexTableAllowed(), !input.getDictionaryWords().isEmpty());
        System.out.println(resultPrint);
    }

    private void appendIndexTable(CounterResultData result, StringBuilder resultPrint, boolean indexTableAllowed, boolean isDictionaryFilled) {
        if (indexTableAllowed) {
            long unknownWords = result.getIndexTable().stream()
                    .filter((value) -> value.contains("*")).count();
            resultPrint.append("\nIndex table: ");
            if (isDictionaryFilled) {
                resultPrint.append("(unknown: ").append(unknownWords).append(")");
            }
            result.getIndexTable().forEach((value) ->
                    resultPrint
                            .append("\n")
                            .append(value)
            );
        }
    }
}
