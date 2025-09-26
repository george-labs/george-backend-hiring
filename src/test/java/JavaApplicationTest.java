import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    @Test
    public void mainWithFileNameReturnsParsedFileCount() {

        String simulatedInput = "Mary had a little lamb";
        PrintStream originalOut = System.out;

        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream testPrint = new PrintStream(testOut);

        System.setIn(testIn);
        System.setOut(testPrint);

        // Call main method
        JavaApplication.main(new String[]{});

        // Flush output
        testPrint.flush();

        // Check output
        String output = testOut.toString();
        System.setOut(originalOut);

        String[] split = output.split(": ");
        String res = split[2].trim();

        String expected = "4";
        assertEquals(expected, res);
    }
}
