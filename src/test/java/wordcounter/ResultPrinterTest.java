package wordcounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultPrinterTest {

    private final ResultPrinter resultPrinter = new ResultPrinter();

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void printWordCount_printsProvidedNumberOfWords() {
        long wordCount = 8;
        resultPrinter.printWordCount(wordCount);
        assertEquals("Word count: " + wordCount , outputStreamCaptor.toString().trim());
    }
}
