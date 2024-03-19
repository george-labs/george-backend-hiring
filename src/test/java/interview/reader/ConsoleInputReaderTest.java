package interview.reader;

import interview.exception.ReaderException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Xenofon Zinoviou
 */
class ConsoleInputReaderTest {

    private ConsoleInputReader testClass;

    @Test
    void test_GivenValidInput_thenReturnInputAsString() {
        String text = "Hello World";
        testClass = new ConsoleInputReader(getInputStream(text));

        final String result = testClass.readInput();

        assertEquals(text, result);
    }

    @Test
    void test_GivenEmptyInput_thenReturnInputAsEmptyString() {
        String text = "\r";
        testClass = new ConsoleInputReader(getInputStream(text));

        final String result = testClass.readInput();

        assertEquals("", result);
    }

    @Test
    void test_GivenNullInput_thenThrowReaderException() {
        testClass = new ConsoleInputReader(null);
        final ReaderException ex = Assertions.assertThrows(ReaderException.class, () -> testClass.readInput());
        assertEquals("Fail: could not retrieve input", ex.getMessage());
    }

    private InputStream getInputStream(String text) {
        return new ByteArrayInputStream(text.getBytes());
    }
}
