import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class JavaApplicationIntegrationTest {
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private final String testInput = "Mary had a little lamb";
    private final ByteArrayInputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
    @BeforeEach
    public void setUp() {
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testFlowNoIndex() {
        JavaApplication.main(new String[]{});

        String capturedOutput = outputStreamCaptor.toString().trim();

        Assertions.assertEquals("Enter text: Number of words:4, unique: 4, average word length: 4.25 characters",
                capturedOutput);
    }

    @Test
    public void testFlowWithIndex() {
        JavaApplication.main(new String[]{"-index"});

        String capturedOutput = outputStreamCaptor.toString().trim();

        Assertions.assertEquals("Enter text: Number of words:4, unique: 4, average word length: 4.25 characters\n"
                        + "Index:\nMary\nhad\na\nlittle\nlamb",
                capturedOutput);
    }
}
