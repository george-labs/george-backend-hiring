package unit.input.impl;

import input.impl.ConsoleInputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

public class ConsoleInputReaderTest {

    private ConsoleInputReader consoleInputReader;

    @BeforeEach
    void setUp() {
        consoleInputReader = new ConsoleInputReader();
    }

    @Test
    void givenRegularInputText_whenReadLine_thenShouldReturnCorrectInput() {
        String userInputText = "Mary had a little lamb";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInputText.getBytes());
        System.setIn(bais);

        String result = consoleInputReader.readLine();

        assertEquals(userInputText, result);
    }

    @Test
    void givenNullInputText_whenReadLine_thenShouldReturnCorrectInput() {
        String userInputText = "\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInputText.getBytes());
        System.setIn(bais);

        String result = consoleInputReader.readLine();

        assertEquals("", result);
    }

}
