package com.george.interview.counter;

import java.util.Arrays;
import java.util.List;

public class WordCounter implements Counter{

    @Override
    public Long count(String input, List<String> excludeWords) {
        if(input == null) {
            return 0L;
        }

        String[] splitInput = input.split("\\s+");
        return Arrays.stream(splitInput)
                .filter(word -> word.matches("[a-zA-Z]+"))
                .filter(word -> !excludeWords.contains(word))
                .count();
    }
}
