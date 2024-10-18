package io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

class IOHandlerTest {

    public static final String TEST_MARY_TEXT = "Mary had a little lamb";


    @Test
    void getCmdInputTest() {
        IOHandler cmdTestHandler = new IOHandler(new ByteArrayInputStream(TEST_MARY_TEXT.getBytes()));

        final var actualResult = cmdTestHandler.getCmdInput();
        Assertions.assertEquals(TEST_MARY_TEXT, actualResult);
    }

    @Test
    void getAllInputFromStreamTest() {
        IOHandler testHandler = new IOHandler(new ByteArrayInputStream("a\r\naa\r\n".getBytes()));

        final var actualResult = testHandler.getAllInputFromStream();
        Assertions.assertEquals(Arrays.asList("a", "aa"), actualResult);
    }

    @Test
    void getAllInputFromStreamTest_forEmptyInput() {
        IOHandler testHandler = new IOHandler(new ByteArrayInputStream("".getBytes()));

        final var actualResult = testHandler.getAllInputFromStream();
        Assertions.assertEquals(0, actualResult.size());
    }
}