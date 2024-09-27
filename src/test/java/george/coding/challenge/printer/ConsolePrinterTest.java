package george.coding.challenge.printer;

import george.coding.challenge.Consts;
import george.coding.challenge.job.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsolePrinterTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @BeforeEach
    void setUp() {
        printStream = new PrintStream(outputStream);
    }

    @Test
    void shouldSentTextToPrintStream() {
        // given
        Result result = new Result(5, 5);
        ConsolePrinter consolePrinter = new ConsolePrinter(printStream);

        // when
        consolePrinter.print(result);

        // then
        String expectedOutput = String.format(Consts.RESULT_TEXT, result.wordCount()) + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }

}