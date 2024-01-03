package com.erste.filter;

import com.erste.util.ResourceFileReader;

import java.util.List;
import java.util.stream.Collectors;

public class StopWordFilter implements WordFilter {

    public static final String DEFAULT_STOPWORDS_FILENAME = "stopwords.txt";
    private List<String> stopWords;
    private ResourceFileReader resourceFileReader;

    public StopWordFilter(ResourceFileReader resourceFileReader) {
        this.resourceFileReader = resourceFileReader;

        stopWords = resourceFileReader.readFile(DEFAULT_STOPWORDS_FILENAME);
    }

    @Override
    public List<String> filter(List<String> inputWords) {
        return inputWords.stream()
                .filter(word -> !stopWords.contains(word))
                .collect(Collectors.toList());
    }


}
