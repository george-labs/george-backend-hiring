package com.george.interview;

import kotlin.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WordCounterTest {

    public static final List<Pair<String, Long>> testSuite = Arrays.asList(
            new Pair<>("Hello World", 2L),
            new Pair<>("Hello  World!", 1L),
            new Pair<>("Hello! World!", 0L),
            new Pair<>("        ", 0L),
            new Pair<>("", 0L),
            new Pair<>(" word, word. word? word! 123 $$ word", 1L),
            new Pair<>("      word!       word ", 1L),
            new Pair<>(null, 0L)

    );

    @Test
    void wordCounterTest() {
        Counter counter = new WordCounter();
        testSuite.forEach(pair -> Assertions.assertEquals(pair.getSecond().longValue(), counter.count(pair.getFirst()).longValue()));
    }
}
