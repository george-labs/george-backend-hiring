package service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IOServiceImplTest {

    @ParameterizedTest
    @MethodSource(value = "fileNameProvider")
    void extractStringFromFileTest(String filename, String expectedString) {
        //arrange
        IOServiceImpl ioService = new IOServiceImpl();
        //acts
        var actualString = ioService.extractStringFromFile(filename);
        //asserts
        Assertions.assertEquals(expectedString, actualString);
    }

    static Stream<Arguments> fileNameProvider(){
        return Stream.of(
                Arguments.of("mytext.txt","Mary had a little lamb"),
                Arguments.of("my.txt",""),
                Arguments.of("",""),
                Arguments.of(null,"")
        );
    }
}
