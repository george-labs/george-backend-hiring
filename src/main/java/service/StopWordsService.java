package service;

import utils.TextFileReader;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsService {

    private final String STOPWORDS_FILE = "src/main/resources/stopwords.txt";
    private final TextFileReader textFileReader;

    public StopWordsService(TextFileReader textFileReader) {
        this.textFileReader = textFileReader;
    }

    public Set<String> getStopWords(String stopWordsFile) {
        String stopWordsText = textFileReader.readFile(STOPWORDS_FILE);
        return Arrays.stream(stopWordsText.split("\\s+"))
                .map(String::trim)
                .map(String::toLowerCase)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toUnmodifiableSet());
    }

}
