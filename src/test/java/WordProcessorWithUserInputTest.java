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

    }

    @Test
    void testRun_givenValidText_thenPrintNumberOfWords() {
        init("Mary had a little lamb");
        assertTrue(byteArrayOutput.toString().isEmpty());
        testSubject.process();
        output.flush();
        assertEquals("Enter text: Number of words: 4, unique: 4", byteArrayOutput.toString());
    }

    @Test
    void testRun_givenValidText2_thenPrintNumberOfWords() {
        init("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        assertTrue(byteArrayOutput.toString().isEmpty());
        testSubject.process();
        output.flush();
        assertEquals("Enter text: Number of words: 9, unique: 7", byteArrayOutput.toString());
    }

    void init(String inputText) {
        input = new ByteArrayInputStream(inputText.getBytes());
        byteArrayOutput = new ByteArrayOutputStream();
        output = new PrintStream(byteArrayOutput);
        testSubject = new WordProcessorWithUserInput(input, output);
    }
}