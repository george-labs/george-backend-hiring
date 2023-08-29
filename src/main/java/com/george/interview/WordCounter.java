package com.george.interview;

import java.util.Arrays;

public class WordCounter implements Counter{

    @Override
    public Long count(String input) {
        if(input == null) {
            return 0L;
        }
        String[] splitInput = input.split("\\s+");
        return Arrays.stream(splitInput)
                .filter(word -> word.matches("[a-zA-Z]+"))
                .count();
    }
}
