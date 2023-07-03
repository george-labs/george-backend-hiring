import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    @Test
    void testWithFileInput() {
        String filePath = "src/test/resources/inputFiles/exampleInput.txt";

        String[] args = {filePath};

        PrintStream stdOut = System.out;

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        JavaApplication.main(args);

        final String standardOutput = myOut.toString();
        System.setOut(stdOut);
        assertEquals("Number of words: 4", standardOutput.trim());
    }

    @Test
    void testWithConsoleInput() {
        InputStream stdIn = System.in;
        System.setIn(new ByteArrayInputStream("Mary had a little lamb".getBytes()));
        String[] emptyArray = {};

        PrintStream stdOut = System.out;

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        JavaApplication.main(emptyArray);

        final String standardOutput = myOut.toString();
        System.setOut(stdOut);
        System.setIn(stdIn);
        assertEquals("Number of words: 4", standardOutput.trim());


    }

}
