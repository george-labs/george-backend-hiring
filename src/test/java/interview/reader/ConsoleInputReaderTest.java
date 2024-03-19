package interview.reader;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
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
        String text = "";
        testClass = new ConsoleInputReader(getInputStream(text));

        final String result = testClass.readInput();

        assertEquals(text, result);
    }

    private InputStream getInputStream(String text) {
        return new ByteArrayInputStream(text.getBytes());
    }
}
