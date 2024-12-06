import com.erste.mm.model.UniqueCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JavaApplicationITest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final String EXPECTED_OUTPUT = """
           Enter text: Number of words: 4, unique: 4; average word length: 4.25 charactersIndex:
           had
           lamb
           Mary
           little
           """;

    @BeforeEach
    void setUp() throws Exception {
        System.setIn(new ByteArrayInputStream("Mary had a little lamb\n".getBytes()));
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testApplicationLogicFlow() {
        String[] args = {"-index"};

        UniqueCount uniqueCount = JavaApplication.processWordsInput(args);

        Assertions.assertEquals(4, uniqueCount.getUniqueCount());
        Assertions.assertEquals(4, uniqueCount.getCount());
    }

    @Test
    void testSystemOutputIsAsExpected() {
        String[] args = {"-index"};

        JavaApplication.processAndOutput(args);

        String output = outputStreamCaptor.toString();

        Assertions.assertEquals(EXPECTED_OUTPUT, output);
    }
}
