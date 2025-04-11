package reader;

import org.junit.jupiter.api.Test;
import service.reader.InputReader;
import service.reader.Reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputReaderTest {

    @Test
    void testInputReaderAcceptableInput() {
        String input = "add 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Reader inputReader = new InputReader();
        assertEquals(input, inputReader.readInput());
    }

    @Test
    void testInputReaderNullInput() {
        System.setIn(null);

        Reader inputReader = new InputReader();
        assertTrue(inputReader.readInput().isEmpty());
    }
}
