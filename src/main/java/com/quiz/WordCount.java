package com.quiz;

import com.quiz.reader.FileReader;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCount implements IWordCount {
    private static final String REGEX = "[a-zA-Z]+";
    private FileReader stopWordsReader;


    public WordCount() {
    }

    public WordCount(FileReader stopWordsReader) {
        this.stopWordsReader = stopWordsReader;
    }

    @Override
    public long count(String text) {
        Set<String> stopWords;
        if (stopWordsReader == null) {
            stopWords = Set.of();
        } else {
            stopWords = Arrays.stream(stopWordsReader.read().split("\n"))
                    .collect(Collectors.toSet());
        }
        return Arrays.stream(Objects.toString(text, "").split(" "))
                .filter(word -> word.matches(REGEX) && !stopWords.contains(word))
                .count();
    }

}