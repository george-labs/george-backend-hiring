package com.george.interview.counter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter implements Counter {

    @Override
    public CounterResultData count(String input, List<String> excludeWords) {
        List<String> preparedInput = prepareInput(input, excludeWords);
        return new CounterResultData(
                (long) preparedInput.size(),
                countUnique(preparedInput)
        );
    }

    private Long countUnique(List<String> input) {
        return input.stream().distinct().count();
    }

    private List<String> prepareInput(String input, List<String> excludeWords) {
        if (input == null) {
            return Collections.emptyList();
        }

        String[] splitInput = input.split("[\\s.-]+");
        return Arrays.stream(splitInput)
                .filter(word -> word.matches("[a-zA-Z]+"))
                .filter(word -> !excludeWords.contains(word))
                .collect(Collectors.toList());
    }
}
