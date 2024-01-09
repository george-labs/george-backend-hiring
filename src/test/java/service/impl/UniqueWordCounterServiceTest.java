package service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import service.UniqueWordCounterService;

import java.util.stream.Stream;

public class UniqueWordCounterServiceTest {

    @ParameterizedTest
    @MethodSource(value = "textProvider")
    void uniqueWordsCounterTest(String text, int expectedCountOfUniqueWords) {
        //arrange
        UniqueWordCounterService uniqueWordCounterService = new UniqueWordCounterServiceImpl();
        //acts
        var actualCountOfUniqueWords = uniqueWordCounterService.processText(text);
        //asserts
        Assertions.assertEquals(expectedCountOfUniqueWords, actualCountOfUniqueWords);
    }

    static Stream<Arguments> textProvider(){
        return Stream.of(
                Arguments.of("Mary had a little lamb",5),
                Arguments.of("Ma23ry had a little lamb",5),
                Arguments.of("14231 fdgsd",2),
                Arguments.of("14231 skill skill job",3),
                Arguments.of("",0)
        );
    }
}
