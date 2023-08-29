package com.george.interview.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static com.george.interview.counter.WordCounterTestSuites.*;

public class WordCounterTest {

    @Test
    void wordCounterTest() {
        Counter counter = new WordCounter();
        testSuite.forEach(pair ->
                Assertions.assertEquals(
                        pair.getSecond().longValue(),
                        counter.count(pair.getFirst(), Collections.emptyList())
                )
        );
    }

    @Test
    void wordCounterTestForBadWord() {
        Counter counter = new WordCounter();
        testSuiteBadWords.forEach(pair ->
                Assertions.assertEquals(
                        pair.getSecond().longValue(),
                        counter.count(pair.getFirst(), excludedWords)
                )
        );
    }
}
