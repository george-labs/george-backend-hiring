import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordProcessorWithUserInputTest {

    private WordProcessorWithUserInput testSubject;

    private InputStream input;
    private PrintStream output;
    private ByteArrayOutputStream byteArrayOutput;

    @BeforeEach
    public void setUp() {
        input = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        byteArrayOutput = new ByteArrayOutputStream();
        output = new PrintStream(byteArrayOutput);
        testSubject = new WordProcessorWithUserInput(input, output);
    }

    @Test
    void testRun_givenValidText_thenPrintNumberOfWords() {
        assertTrue(byteArrayOutput.toString().isEmpty());
        testSubject.process();
        output.flush();
        assertEquals("Enter text: Number of words: 4", byteArrayOutput.toString());
    }
}