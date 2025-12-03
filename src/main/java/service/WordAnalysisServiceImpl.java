package service;

import dto.ResultOutput;

import java.util.Arrays;
import java.util.List;

public class WordAnalysisServiceImpl implements WordAnalysisService {

    @Override
    public ResultOutput analyze(String inputString) {
        List<String> words = getWords(sanitizeString(inputString))
                .stream()
                .filter(input -> !input.isBlank())
                .toList();


        return new ResultOutput
                .Builder()
                .withWordCount(words.size())
                .withWords(words)
                .build();
    }

    private String sanitizeString(String inputString) {
        return inputString.replaceAll("[^a-zA-Z ]", "");
    }

    private List<String> getWords(String inputString) {
        return Arrays
                .stream(inputString
                .split(" "))
                .toList();
    }
}
