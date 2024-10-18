import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JavaApplicationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void mainTest_withoutFileParameter() {
        final var expectedResult = "Enter text:\n" +
                "Number of words: 4\n";
        final var inputStream = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        System.setIn(inputStream);

        JavaApplication.main(new String[0]);
        Assertions.assertEquals(expectedResult, outContent.toString());
    }

    @Test
    void mainTest_withFileParameter() {
        final var expectedResult = "Number of words: 4\n";

        JavaApplication.main(new String[]{"src/test/resources/testfile.txt"});
        Assertions.assertEquals(expectedResult, outContent.toString());
    }

    @Test
    void mainTest_ioExceptionThrown_whenFileNotFound() {
        final var expectedResult = "###Exception class: class java.nio.file.NoSuchFileException";
        JavaApplication.main(new String[]{"src/test/resources/nonexistent.txt"});

        Assertions.assertTrue(outContent.toString().contains(expectedResult));
    }
}
