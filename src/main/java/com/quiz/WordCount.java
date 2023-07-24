package com.quiz;

import java.util.Arrays;
import java.util.Objects;

public class WordCount implements IWordCount {
    private static final String REGEX = "[a-zA-Z]+";

    @Override
    public long count(String text) {
        return Arrays.stream(Objects.toString(text, "").split(" "))
                .filter(word -> word.matches(REGEX))
                .count();
    }

}