package com.erste;

import com.erste.service.FilteringWordCounter;
import com.erste.service.WordCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class JavaApplicationTest {

//- Mary had a little lamb - 5words
//- Mary %had a lit#tle lamb - 3words
//- Mary had a\nlittle lamb -5words
//- Mary had a lit\ntle lamb - 6words

    private static WordCounter wordCounter;

    @BeforeAll
    public static void setUp() {
        wordCounter = new FilteringWordCounter();
    }

    public static Stream<Arguments> wordsInput() {
        return Stream.of(
            Arguments.of("Basic input", "Mary had a little lamb", 5),
            Arguments.of("Special characters input", "Mary %had a lit%tle lamb", 3),
            Arguments.of("Input with multiple whitespaces", "Mary      had a little lamb", 5),
            Arguments.of("Input with line breaks", "Mary had a litt\nle lamb", 6),
            Arguments.of("Input with line breaks", "Mary had a \nlittle lamb", 5)
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
