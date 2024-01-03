package com.erste.service;

import com.erste.filter.WordFilter;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FilteringWordCounter implements WordCounter {

    public static Logger log = Logger.getLogger(FilteringWordCounter.class.getName());
    public static final String WHITESPACE = " ";
    public static final String MULTIPLE_WHITESPACE_REGEX = "\\s++";
    public static final String LETTERS_ONLY_REGEX = "[a-z,A-Z]*";

    private final WordFilter stopWordsFilter;


    public FilteringWordCounter(WordFilter stopWordsFilter) {
        this.stopWordsFilter = stopWordsFilter;
    }

    @Override
    public int countWords(String input) {
        log.info("Input: " + input);

        input = replaceLineBreaksWithWhitespaces(input);
        log.info("Filtered linebreaks Input: " + input);

        input = trimLeadingAndTailingWhitespaces(input);
        log.info("Filtered trimmed: " + input);

        List<String> words = separateInputIntoWords(input);
        log.info("Raw Words: " + words);

        List<String> filteredWords = filterNotAcceptableWords(words);
        log.info("Valid Words: " + filteredWords);

        filteredWords = filterStopWords(filteredWords);

        return filteredWords.size();
    }

    private List<String> filterStopWords(List<String> words) {
        return stopWordsFilter.filter(words);
    }

    private List<String> filterNotAcceptableWords(List<String> words) {
        return words.stream()
                .filter(word -> word.matches(LETTERS_ONLY_REGEX))
                .filter(word -> !word.isBlank())
                .collect(Collectors.toList());
    }

    private List<String> separateInputIntoWords(String input) {
        String[] words = input.split(MULTIPLE_WHITESPACE_REGEX);
        return Arrays.asList(words);
    }

    private String trimLeadingAndTailingWhitespaces(String input) {
        return input.trim();
    }

    private String replaceLineBreaksWithWhitespaces(String input) {
        String lineSeparator = System.lineSeparator();
        return input.replaceAll(lineSeparator, WHITESPACE);
    }
}
