import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JavaApplicationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void applicationWorkflowWithoutIndexNeedsToPrintResultWithoutIndex() {
        JavaApplication.main(new String[]{"mytext.txt"});

        Assertions.assertEquals("Number of words: 5, unique: 4; average word length: 4.2 characters", outContent.toString().trim());
    }

    @Test
    public void applicationWorkflowWithIndexNeedsToPrintResultWithIndex() {
        JavaApplication.main(new String[]{"mytext.txt", "-index"});

        String[] outputLines = outContent.toString().trim().split("\\r");
        Assertions.assertArrayEquals(new String[] {
                "Number of words: 5, unique: 4; average word length: 4.2 characters",
                "\nIndex:",
                "\nlittle",
                "\nlamb",
                "\nlamb",
                "\nhad",
                "\nMary"
        }, outputLines);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
