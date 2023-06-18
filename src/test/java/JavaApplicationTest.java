import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Objects;

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
    void testMain_userInput_singleWordInput() {
        // Given
        var input = "Hello";
        setSystemInput(input);

        // When
        JavaApplication.main(new String[]{});
        var output = outputStream.toString().trim();

        // Then
        assertTrue(output.contains("1"));
    }

    @Test
    void testMain_userInput_multipleWordsInput() {
        // Given
        var input = "May the Force be with you";
        setSystemInput(input);

        // When
        JavaApplication.main(new String[]{});
        var output = outputStream.toString().trim();

        // Then
        assertTrue(output.contains("5"));
    }

    @Test
    void testMain_userInput_emptyInput() {
        // Given
        var input = "\n";
        setSystemInput(input);

        // When
        JavaApplication.main(new String[]{});
        var output = outputStream.toString().trim();

        // Then
        assertTrue(output.contains("0"));
    }

    @Test
    void testMain_userInput_withNewLine() {
        // Given
        var input = "It's just a flesh wound!\nTis But a Scratch.";
        setSystemInput(input);

        // When
        JavaApplication.main(new String[]{});
        var output = outputStream.toString().trim();

        // Then
        assertTrue(output.contains("2"));
    }

    @Test
    void testMain_fileInput() {
        // Given
        String filename = "/testfile.txt";
        String filePath = Objects.requireNonNull(getClass().getResource(filename)).getPath();
        setSystemInput("never read");

        // When
        JavaApplication.main(new String[]{filePath});
        var output = outputStream.toString().trim();

        // Then
        assertTrue(output.contains("10"));
    }

    @Test
    void testMain_fileInput_nonexistentFile() {
        // Given
        String filePath = "/nonexistent_testfile.txt";
        setSystemInput("never read");

        // When
        JavaApplication.main(new String[]{filePath});
        var output = outputStream.toString().trim();

        // Then
        assertTrue(output.contains("0"));
    }

    private void setSystemInput(String input) {
        var inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}