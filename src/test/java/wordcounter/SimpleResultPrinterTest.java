package wordcounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wordcounter.model.WordCountDto;
import wordcounter.printer.SimpleResultPrinter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleResultPrinterTest {

    private final SimpleResultPrinter simpleResultPrinter = new SimpleResultPrinter();

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void printWordCount_printsProvidedNumberOfWords() {
        WordCountDto wordCountDto = new WordCountDto(2, 1, 1.1, List.of("test"));
        simpleResultPrinter.printWordCount(wordCountDto);
        assertEquals("Number of words: 2, unique: 1, average word length: 1.10 characters", outputStreamCaptor.toString().trim());
    }
}
