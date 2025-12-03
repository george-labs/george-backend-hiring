package service;

import dto.ResultOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordAnalysisServiceImpl implements WordAnalysisService {

    private StopWordService stopWordService;

    public WordAnalysisServiceImpl(StopWordService stopWordService) {
        this.stopWordService = stopWordService;
    }


    @Override
    public ResultOutput analyze(String inputString) {
        List<String> ignorableWords = stopWordService.getIgnoredWords();

        List<String> words = getWords(sanitizeString(inputString))
                .stream()
                .filter(input -> !input.isBlank())
                .filter(word -> !ignorableWords.contains(word))
                .toList();


        return new ResultOutput
                .Builder()
                .withWordCount(words.size())
                .withWords(words)
                .withUniqueCount(getUniques(words))
                .build();
    }

    private int getUniques(List<String> words) {
        return new HashSet<>(words).size();
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
