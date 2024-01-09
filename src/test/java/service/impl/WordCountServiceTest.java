package service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WordCountServiceTest {

    @ParameterizedTest
    @MethodSource(value = "textProvider")
    void name(String text, int expectedCount) {
        //arrange
        WordCountServiceImpl wordCountService = new WordCountServiceImpl();
        //acts
        var actualCount = wordCountService.checkTheCountOfWord(text);
        //asserts
        Assertions.assertEquals(expectedCount, actualCount);
    }

    static Stream<Arguments> textProvider(){
        return Stream.of(
                Arguments.of("Mary had a little lamb",5),
                Arguments.of("Ma23ry had a little lamb",4),
                Arguments.of("14231 fdgsd",1),
                Arguments.of("14231 df4564",0),
                Arguments.of("",0)
        );
    }
}
