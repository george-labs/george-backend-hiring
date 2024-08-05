package wordcounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wordcounter.model.WordCountDto;

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
        WordCountDto wordCountDto = new WordCountDto(2, 1);
        resultPrinter.printWordCount(wordCountDto);
        assertEquals("Number of words: 2, unique: 1", outputStreamCaptor.toString().trim());
    }
}
