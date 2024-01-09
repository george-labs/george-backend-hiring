package service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StopWordsCheckerServiceTest {

    @ParameterizedTest
    @MethodSource(value = "textProvider")
    void removeStopWordsFromSentenceTest(String text, String expectedString) {
        //arrange
        StopWordsCheckerServiceImpl stopWordsCheckerService = new StopWordsCheckerServiceImpl();
        //acts
        var actualString = stopWordsCheckerService.processSentence(text);
        //asserts
        Assertions.assertEquals(expectedString, actualString);
    }

    static Stream<Arguments> textProvider(){
        return Stream.of(
                Arguments.of("Mary had a little lamb","Mary had little lamb"),
                Arguments.of("Mary had the little lamb","Mary had little lamb"),
                Arguments.of("Mary had on little lamb","Mary had little lamb"),
                Arguments.of("Mary had off little lamb","Mary had little lamb"),
                Arguments.of("Mary had to little lamb","Mary had little lamb"),
                Arguments.of("Mary had little lamb","Mary had little lamb"),
                Arguments.of("",""),
                Arguments.of(null, "")
        );
    }
}
