package com.george.interview.counter;

import kotlin.Pair;

import java.util.Arrays;
import java.util.List;

public class WordCounterTestSuites {
    public static final List<Pair<String, Long>> testSuite = Arrays.asList(
            new Pair<>("Hello World", 2L),
            new Pair<>("Hello  World!", 1L),
            new Pair<>("Hello! World!", 0L),
            new Pair<>("        ", 0L),
            new Pair<>("", 0L),
            new Pair<>(" word, word| word? word! 123 $$ word", 1L),
            new Pair<>("      word!       word ", 1L),
            new Pair<>(null, 0L),
            new Pair<>("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 12L)

    );
    public static final List<Pair<String, Long>> testSuiteBadWords = Arrays.asList(
            new Pair<>("Hello the", 1L),
            new Pair<>("on", 0L),
            new Pair<>("Hello the Hello", 2L),
            new Pair<>("the a on off", 0L),
            new Pair<>("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 9L)

    );
    public static final List<Pair<String, Long>> testSuiteUnique = Arrays.asList(
            new Pair<>("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 7L),
            new Pair<>("Humpty-Dumpty sat on a wall. dawd! dawd@", 4L)

    );
    public static final List<String> excludedWords = Arrays.asList("the", "a", "on", "off");
}
