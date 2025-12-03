package service;

import java.util.Arrays;
import java.util.List;

public class WordAnalysisServiceImpl implements WordAnalysisService {

    @Override
    public String sanitizeString(String inputString) {
        return inputString.replaceAll("[^a-zA-Z]", "");
    }

    @Override
    public List<String> getWords(String inputString) {
        return Arrays
                .stream(inputString
                .split(" "))
                .toList();
    }
}
