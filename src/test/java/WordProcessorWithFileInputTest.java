import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordProcessorWithFileInputTest {
    private WordProcessorWithFileInput testSubject;

    private InputStream input;
    private PrintStream output;
    private ByteArrayOutputStream byteArrayOutput;

    @BeforeEach
    public void setUp() {
        input = getClass().getResourceAsStream("test-mytext.txt");
        byteArrayOutput = new ByteArrayOutputStream();
        output = new PrintStream(byteArrayOutput);
        testSubject = new WordProcessorWithFileInput(input, output);
    }

    @AfterEach
    public void tearDown() throws IOException {
        input.close();
    }

    @Test
    void testRun_givenValidText_thenPrintNumberOfWords() {
        assertTrue(byteArrayOutput.toString().isEmpty());
        testSubject.process();
        output.flush();
        assertEquals("Number of words: 4, unique: 4", byteArrayOutput.toString());
    }
}