package com.george.interview.counter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCounter implements Counter {

    @Override
    public CounterResultData count(String input, List<String> excludeWords) {
        return count(input, excludeWords, false, Collections.emptySet());
    }

    @Override
    public CounterResultData count(String input, List<String> excludeWords, boolean indexTableAllowed) {
        return count(input, excludeWords, indexTableAllowed, Collections.emptySet());
    }

    @Override
    public CounterResultData count(String input, List<String> excludeWords, boolean indexTableAllowed, Set<String> dictionaryWords) {
        List<String> preparedInput = prepareInput(input, excludeWords);
        List<String> countedIndexTable = countIndexTable(preparedInput, indexTableAllowed);
        return new CounterResultData(
                (long) preparedInput.size(),
                countUnique(preparedInput),
                countAverage(preparedInput),
                modifyIndexTable(countedIndexTable, dictionaryWords)
        );
    }

    private List<String> modifyIndexTable(List<String> countedIndexTable, Set<String> dictionaryWords) {
        if (dictionaryWords.isEmpty()) {
            return countedIndexTable;
        } else {
            return countedIndexTable.stream()
                    .map(word -> !dictionaryWords.contains(word) ? word + "*" : word)
                    .collect(Collectors.toList());
        }
    }

    private List<String> countIndexTable(List<String> preparedInput, boolean indexTableAllowed) {
        if (!indexTableAllowed) {
            return Collections.emptyList();
        } else {
            return preparedInput.stream()
                    .distinct()
                    .sorted(String::compareToIgnoreCase)
                    .collect(Collectors.toList());
        }
    }

    private Long countUnique(List<String> input) {
        return input.stream().distinct().count();
    }

    private Double countAverage(List<String> input) {
        return input.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
    }

    private List<String> prepareInput(String input, List<String> excludeWords) {
        if (input == null) {
            return Collections.emptyList();
        }

        String[] splitInput = input.split("[\\s.]+");
        return Arrays.stream(splitInput)
                .filter(word -> word.matches("[a-zA-Z\\-]+"))
                .filter(word -> !excludeWords.contains(word))
                .collect(Collectors.toList());
    }
}
