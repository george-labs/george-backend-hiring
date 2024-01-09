package service.impl;

import service.UniqueWordCounterService;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UniqueWordCounterServiceImpl implements UniqueWordCounterService {

    @Override
    public int processText(String text) {
        var splitText = text.split(" |-|;");
        var uniqueWords = Arrays.stream(splitText)
                .filter(s -> !s.isBlank() || !s.isEmpty())
                .collect(Collectors.toSet());
        return uniqueWords.size();
    }
}
