import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    public void testMainApplicationWithGivenFile() {
        init();

        JavaApplication.main(new String[]{"onlyrealwords.txt"});

        assertEquals("Enter text: Number of words: 5", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testApplicationMainWithCommandLineWhenFileNotSpecified() {
        init();
        System.setIn(new ByteArrayInputStream("Mary had one little lamb".getBytes()));

        JavaApplication.main(new String[]{});

        assertEquals("Enter text: Number of words: 5", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testMainApplicationWithCommandLineWhenFileNotExists() {
        init();
        System.setIn(new ByteArrayInputStream("Mary had one little lamb".getBytes()));

        JavaApplication.main(new String[]{"filenotexists.txt"});

        assertEquals("Enter text: Number of words: 5", outputStreamCaptor.toString()
                .trim());
    }

    private void init() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDow() {
        System.setOut(standardOut);
    }
}
