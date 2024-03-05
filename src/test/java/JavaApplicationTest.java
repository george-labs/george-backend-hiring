import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.InputFileUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JavaApplicationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testFileNameInput() {
        JavaApplication.main(new String[]{InputFileUtils.getInputFile()});
        Assertions.assertTrue(outContent.toString().contains("Number of words: 7, unique: 6; average word length: 6.43 characters"));
    }

    @Test
    public void testInvalidFileNameInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> JavaApplication.main(new String[]{"invalid.txt"}));
    }

    @Test
    public void testStandardInput() {
        ByteArrayInputStream testIn = new ByteArrayInputStream("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.\n".getBytes());
        System.setIn(testIn);
        JavaApplication.main(new String[]{});
        Assertions.assertTrue(outContent.toString().contains("Number of words: 7, unique: 6; average word length: 6.43 characters"));
    }

    @Test
    public void testStandardInputWithIndex() {
        ByteArrayInputStream testIn = new ByteArrayInputStream("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.\n".getBytes());
        System.setIn(testIn);
        JavaApplication.main(new String[]{"-index"});
        Assertions.assertTrue(outContent.toString().contains("Number of words: 7, unique: 6; average word length: 6.43 characters"));
        Assertions.assertTrue(outContent.toString().contains("Index:"));
    }

    @Test
    public void testCreateIndex() {
        JavaApplication.main(new String[]{"-index", InputFileUtils.getInputFile()});
        Assertions.assertTrue(outContent.toString().contains("Number of words: 7, unique: 6; average word length: 6.43 characters"));
        Assertions.assertTrue(outContent.toString().contains("Index:"));
    }

    @Test
    public void testCreateIndexArgumentAtEnd() {
        JavaApplication.main(new String[]{InputFileUtils.getInputFile(), "-index"});
        Assertions.assertTrue(outContent.toString().contains("Number of words: 7, unique: 6; average word length: 6.43 characters"));
        Assertions.assertTrue(outContent.toString().contains("Index:"));
    }
}
