import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class JavaApplicationTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setIn(new ByteArrayInputStream("Test sentence.".getBytes()));
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testCountFromInput() {
        JavaApplication.main(new String[]{});

        assertEquals("Enter text: \r\nNumber of words: 2, unique: 2; average word length: 6.0", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testCountFromFile() {
        JavaApplication.main(new String[]{"src/test/resources/testFile.txt"});

        assertEquals("Number of words: 7, unique: 6; average word length: 6.43", outputStreamCaptor.toString().trim());
    }
}
