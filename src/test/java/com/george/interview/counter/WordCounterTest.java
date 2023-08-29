package com.george.interview.counter;

import kotlin.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.george.interview.counter.WordCounterTestSuites.*;

public class WordCounterTest {

    @Test
    void wordCounterTest() {
        Counter counter = new WordCounter();
        testSuite.forEach(pair ->
                Assertions.assertEquals(
                        pair.getSecond().longValue(),
                        counter.count(pair.getFirst(), Collections.emptyList()).longValue()
                )
        );
    }

    @Test
    void wordCounterTestForBadWord() {
        Counter counter = new WordCounter();
        testSuiteBadWords.forEach(pair ->
                Assertions.assertEquals(
                        pair.getSecond().longValue(),
                        counter.count(pair.getFirst(), excludedWords).longValue()
                )
        );
    }
}
