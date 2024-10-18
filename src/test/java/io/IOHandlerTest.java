package io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

class IOHandlerTest {

    @Test
    void getCmdInputTest() {
        IOHandler cmdTestHandler = new IOHandler(
            new ByteArrayInputStream("Mary had a little lamb".getBytes()),
            System.out
        );

        final var actualResult = cmdTestHandler.getCmdInput();
        Assertions.assertEquals("Mary had a little lamb", actualResult);
    }

    @Test
    void getAllInputFromStreamTest() {
        IOHandler testHandler = new IOHandler(
            new ByteArrayInputStream("a\r\naa\r\n".getBytes()),
            System.out
        );

        final var actualResult = testHandler.getAllInputFromStream();
        Assertions.assertEquals(Arrays.asList("a", "aa"), actualResult);
    }

    @Test
    void getAllInputFromStreamTest_forEmptyInput() {
        IOHandler testHandler = new IOHandler(
            new ByteArrayInputStream("".getBytes()),
            System.out
        );

        final var actualResult = testHandler.getAllInputFromStream();
        Assertions.assertEquals(0, actualResult.size());
    }

}