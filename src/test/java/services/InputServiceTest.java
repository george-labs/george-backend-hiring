package services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputServiceTest {
    private InputService inputService;
    private InputStream originalInputStream;

    @BeforeEach
    public void setup() {
        originalInputStream = System.in; // Save the original System.in
    }

    @AfterEach
    public void tearDown() {
        inputService.close();
        System.setIn(originalInputStream);
    }

    @Test
    void testReadWords_singleWord() {
        // Given
        var input = "Hello";
        setSystemInput(input);
        inputService = new InputService();

        // When
        var userInput = inputService.readWords();

        // Then
        assertEquals(input, userInput);
    }

    @Test
    void testReadWords_multipleWords() {
        // Given
        var input = "Nobody expects the Spanish Inquisition!";
        setSystemInput(input);
        inputService = new InputService();

        // When
        var userInput = inputService.readWords();

        // Then
        assertEquals(input, userInput);
    }

    @Test
    void testReadWords_emptyInput() {
        // Given
        var input = "\n";
        setSystemInput(input);
        inputService = new InputService();

        // When
        var userInput = inputService.readWords();

        // Then
        assertEquals("", userInput);
    }

    @Test
    void testReadWords_withNewLine() {
        // Given
        var input = "It's just a flesh wound!\nTis But a Scratch.";
        setSystemInput(input);
        inputService = new InputService();

        // When
        var userInput = inputService.readWords();

        // Then
        assertEquals("It's just a flesh wound!", userInput);
    }

    private void setSystemInput(String input) {
        var inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
