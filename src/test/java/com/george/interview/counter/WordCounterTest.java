package com.george.interview.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
                        counter.count(pair.getFirst(), Collections.emptyList()).getCount()
                )
        );
    }

    @Test
    void wordCounterTestForBadWord() {
        Counter counter = new WordCounter();
        testSuiteBadWords.forEach(pair ->
                Assertions.assertEquals(
                        pair.getSecond().longValue(),
                        counter.count(pair.getFirst(), excludedWords).getCount()
                )
        );
    }

    @Test
    void wordCounterTestForUnique() {
        Counter counter = new WordCounter();
        testSuiteUnique.forEach(pair ->
                Assertions.assertEquals(
                        pair.getSecond().longValue(),
                        counter.count(pair.getFirst(), excludedWords).getCountUnique()
                )
        );
    }

    @Test
    void wordCounterTestForAverage() {
        Counter counter = new WordCounter();
        testSuiteAverage.forEach(pair ->
                Assertions.assertEquals(
                        pair.getSecond().doubleValue(),
                        counter.count(pair.getFirst(), excludedWords).getAverageWordLength()
                )
        );
    }

    @Test
    void wordCounterTestForIndexTable() {
        Counter counter = new WordCounter();
        testIndexTable.forEach(pair -> {
                    List<String> table = counter.count(pair.getFirst(), excludedWords, true).getIndexTable();
                    for (int i = 0; i < table.size(); i++) {
                        Assertions.assertEquals(table.get(i), pair.getSecond().get(i));
                    }
                }
        );
    }
}
