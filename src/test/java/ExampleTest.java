import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExampleTest {

    private Example testSubject;

    private InputStream input;
    private PrintStream output;
    private ByteArrayOutputStream byteArrayOutput;

    @BeforeEach
    public void setUp() {
        input = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        byteArrayOutput = new ByteArrayOutputStream();
        output = new PrintStream(byteArrayOutput);
        testSubject = new Example(input, output);
    }

    @Test
    void testRun_givenValidText_thenPrintNumberOfWords() {
        assertTrue(byteArrayOutput.toString().isEmpty());
        testSubject.run();
        output.flush();
        assertEquals("Enter text: Number of words: 5", byteArrayOutput.toString());
    }
}