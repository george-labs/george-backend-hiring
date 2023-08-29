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
            new Pair<>("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 10L),
            new Pair<>(".-.", 1L)

    );
    public static final List<Pair<String, Long>> testSuiteBadWords = Arrays.asList(
            new Pair<>("Hello the", 1L),
            new Pair<>("on", 0L),
            new Pair<>("Hello the Hello", 2L),
            new Pair<>("the a on off", 0L),
            new Pair<>("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 7L)

    );
    public static final List<Pair<String, Long>> testSuiteUnique = Arrays.asList(
            new Pair<>("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 6L),
            new Pair<>("Humpty-Dumpty sat on a wall. dawd! dawd@", 3L)

    );
    public static final List<Pair<String, Double>> testSuiteAverage = Arrays.asList(
            new Pair<>("Wello world we can do this", 3.5),
            new Pair<>("Wello world we. can do this. Wello world we. can do this", 3.5),
            new Pair<>("", 0.0),
            new Pair<>(".", 0.0),
            new Pair<>("-", 1.0)

    );
    public static final List<Pair<String, List<String>>> testIndexTable = Arrays.asList(
            new Pair<>("Mary had a little lamb", Arrays.asList("had", "lamb", "little", "Mary"))

    );
    public static final List<String> excludedWords = Arrays.asList("the", "a", "on", "off");
}
