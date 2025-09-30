package cli;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Constants.NUMBER_OF_WORDS_MSG;

public class ConsoleManagerTest {

    private static final String STRING = "Hello World";
    private static final int ONE = 1;

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;

    @AfterEach
    public void restoreSystemInAndSystemOut() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    void printPromptAndReadInput_whenGivenPrompt_ShouldReadIt() {
        ByteArrayInputStream testIn = new ByteArrayInputStream(STRING.getBytes());
        System.setIn(testIn);

        ConsoleManager consoleManager = new ConsoleManagerImpl();
        String actual = consoleManager.printPromptAndReadInput();

        assertEquals(STRING, actual);
    }

    @Test
    void printNumberOfWords_WhenGivenNumberInInput_ShouldPrintFormatedMessageWithGivenNumber() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ConsoleManager consoleManager = new ConsoleManagerImpl();
        consoleManager.printNumberOfWords(ONE);

        String expected = NUMBER_OF_WORDS_MSG.formatted(1);
        assertEquals(expected, outputStream.toString());
    }

}