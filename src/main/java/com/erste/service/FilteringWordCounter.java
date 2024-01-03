package com.erste.service;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FilteringWordCounter implements WordCounter {

    public static Logger log = Logger.getLogger(FilteringWordCounter.class.getName());
    public static final String WHITESPACE = " ";
    public static final String MULTIPLE_WHITESPACE_REGEX = "[\\s++]";
    public static final String LETTERS_ONLY_REGEX = "[a-z,A-Z]";



    @Override
    public int countWords(String input) {
        log.info("Input: " + input);

        input = replaceLineBreaksWithWhitespaces(input);
        log.info("Filtered linebreaks Input: " + input);

        input = filterExcessiveWhitespaces(input);
        log.info("Filtered excessive Input: " + input);

        input = trimLeandingAndTailingWhitespaces(input);
        log.info("Filtered trimmed: " + input);

        List<String> words = separateInputIntoWords(input);
        log.info("Raw Words: " + input);

        List<String> filteredWords = filterNotAcceptableWords(words);
        log.info("Valid Words: " + input);

        return filteredWords.size();
    }

    private List<String> filterNotAcceptableWords(List<String> words) {
        return words.stream()
                .filter(word -> word.matches(LETTERS_ONLY_REGEX))
                .collect(Collectors.toList());
    }

    private List<String> separateInputIntoWords(String input) {
        return Arrays.asList(input.split(WHITESPACE));
    }

    private String trimLeandingAndTailingWhitespaces(String input) {
        return input.trim();
    }

    private String filterExcessiveWhitespaces(String input) {
       return input.replaceAll(MULTIPLE_WHITESPACE_REGEX, WHITESPACE);
    }

    private String replaceLineBreaksWithWhitespaces(String input) {
        String lineSeparator = System.lineSeparator();
        return input.replaceAll(lineSeparator, WHITESPACE);
    }
}