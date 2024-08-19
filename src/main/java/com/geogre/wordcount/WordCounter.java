package com.geogre.wordcount;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern WORDS = Pattern.compile("[a-z,A-Z]+");

    private final String separator;
    private final List<String> stopList;

    public WordCounter(String separator, List<String> stopList) {
        this.separator = separator;
        this.stopList = stopList;
    }

    public long count(String input) {
        if (!isEmpty(input)) {
            String[] tokens = input.split(separator);
            return Arrays.stream(tokens)
                    .filter(token -> WORDS.matcher(token).matches())
                    .filter(token -> !stopList.contains(token))
                    .count();
        }

        return 0;
    }

    private boolean isEmpty(String input) {
        return input.trim().isEmpty();
    }

}
