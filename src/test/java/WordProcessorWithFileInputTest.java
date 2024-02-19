import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordProcessorWithFileInputTest {
    private WordProcessorWithFileInput testSubject;

    private InputStream input;
    private PrintStream output;
    private ByteArrayOutputStream byteArrayOutput;

    @AfterEach
    public void tearDown() throws IOException {
        input.close();
    }

    @Test
    void testRun_givenValidText_thenPrintNumberOfWords() {
        init("test-mytext.txt");
        assertTrue(byteArrayOutput.toString().isEmpty());
        testSubject.process();
        output.flush();
        assertEquals("Number of words: 4, unique: 4", byteArrayOutput.toString());
    }

    @Test
    void testRun_givenValidText2_thenPrintNumberOfWords() {
        init("test-mytext-unique.txt");
        assertTrue(byteArrayOutput.toString().isEmpty());
        testSubject.process();
        output.flush();
        assertEquals("Number of words: 9, unique: 7", byteArrayOutput.toString());
    }

    void init(String fileName) {
        input = getClass().getResourceAsStream(fileName);
        byteArrayOutput = new ByteArrayOutputStream();
        output = new PrintStream(byteArrayOutput);
        testSubject = new WordProcessorWithFileInput(input, output);
    }
}