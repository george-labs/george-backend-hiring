import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaApplicationTest {
    private final InputStream originalInputStream = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void teardown() {
        System.setIn(originalInputStream);
        System.setOut(originalOut);
    }

    @Test
    void testMain_singleWordInput() {
        // Given
        var input = "Hello";
        var inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // When
        JavaApplication.main(null);
        var output = outputStream.toString().trim();

        // Then
        assertTrue(output.contains("1"));
    }

    @Test
    void testMain_multipleWordsInput() {
        // Given
        var input = "May the Force be with you";
        var inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // When
        JavaApplication.main(null);
        var output = outputStream.toString().trim();

        // Then
        assertTrue(output.contains("6"));
    }

    @Test
    void testMain_emptyInput() {
        // Given
        var input = "\n";
        var inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // When
        JavaApplication.main(null);
        var output = outputStream.toString().trim();

        // Then
        assertTrue(output.contains("0"));
    }

    @Test
    void testMain_withNewLine() {
        // Given
        var input = "It's just a flesh wound!\nTis But a Scratch.";
        var inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // When
        JavaApplication.main(null);
        var output = outputStream.toString().trim();

        // Then
        assertTrue(output.contains("3"));
    }
}