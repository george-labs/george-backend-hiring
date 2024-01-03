package com.erste.service;

import com.erste.filter.StopWordFilter;
import com.erste.util.ResourceFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WordCounterTest {


//- Mary had a little lamb - 5words
//- Mary %had a lit#tle lamb - 3words
//- Mary had a\nlittle lamb -5words
//- Mary had a lit\ntle lamb - 6words

    private static FilteringWordCounter wordCounter;

    @BeforeAll
    public static void setUp() {
        ResourceFileReader resourceFileReader = new ResourceFileReader();
        StopWordFilter stopWordFilter = new StopWordFilter(resourceFileReader);
        wordCounter = new FilteringWordCounter(stopWordFilter);
    }

    public static Stream<Arguments> wordsInput() {
        return Stream.of(
                Arguments.of("Basic input", "Mary had a little lamb", 4),
                Arguments.of("Special characters input", "Mary %had a lit%tle lamb", 2),
                Arguments.of("Input with multiple whitespaces", "Mary      had a little lamb", 4),
                Arguments.of("Input with line breaks", "Mary had a litt\nle lamb", 5),
                Arguments.of("Input with line breaks", "Mary had a \nlittle lamb", 4)
        );
    }

    @MethodSource("wordsInput")
    @ParameterizedTest
    public void countWords_whenInputStandard(String testName, String input, int expectedWordCount) {
        //when
        int resultWordCount = wordCounter.countWords(input);

        //then
        Assertions.assertEquals(expectedWordCount, resultWordCount);
    }
}
