package george.coding.challenge.reader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleReaderTest {

    private InputStream backupIn;

    @BeforeEach
    void setUp() {
        backupIn = System.in;
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Hello, World!",
            "JUnit 5 is great ",
            "123 Testing",
            " ",
            "Special characters!@#$%^&*()"
    })
    void shouldReadFromSimulatedInputStream(String text) {
        // Prepare the simulated input
        InputStream inputStream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));

        // Redirect System.in to the simulated input
        System.setIn(inputStream);

        // Create a ConsoleReader instance using the simulated System.in
        ConsoleReader consoleReader = new ConsoleReader(new Scanner(System.in));

        // Call the read method and assert the result
        String result = consoleReader.read();
        assertEquals(text, result, "The read method should return the simulated input.");
    }

    @Test
    void shouldTrowNoSuchElementExceptionWhenNoLineFound() {
        // Prepare the simulated input
        InputStream inputStream = new ByteArrayInputStream("".getBytes(StandardCharsets.UTF_8));

        // Redirect System.in to the simulated input
        System.setIn(inputStream);

        // Create a ConsoleReader instance using the simulated System.in
        ConsoleReader consoleReader = new ConsoleReader(new Scanner(System.in));

        // Call the read method and assert the result
        assertThrows(NoSuchElementException.class, consoleReader::read);
    }

    @AfterEach
    void tearDown() {
        System.setIn(backupIn);
    }
}