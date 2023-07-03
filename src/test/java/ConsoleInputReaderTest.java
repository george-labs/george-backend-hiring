import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleInputReaderTest {

    @Test
    void testReadingInput() throws IOException {

        String inputString = "Mary had a little lamb";
        InputStream stdIn = System.in;
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));

        InputReader consoleInputReader = new ConsoleInputReader();
        String outPutString = consoleInputReader.readInput();

        System.setIn(stdIn);
        assertEquals(inputString, outPutString);
    }

}