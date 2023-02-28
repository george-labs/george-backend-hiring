package wordcount;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WordCountTest {

    private InputStream oldInputStream;
    private PrintStream oldOut;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        oldOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setIn(oldInputStream);
        System.setOut(oldOut);
    }

    @Test
    void main_readInputFromConsole() {
        oldInputStream = System.in;
        InputStream inputStream = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        System.setIn(inputStream);

        WordCount.main(new String[]{});

        assertAll(
                () -> assertTrue(outputStreamCaptor.toString().contains("Enter text:")),
                () -> assertTrue(outputStreamCaptor.toString().contains("Number of words: 4"))
        );

    }

    @Test
    void main_readInputFromFile() {
        WordCount.main(new String[]{"mytext.txt"});
        assertTrue(outputStreamCaptor.toString().contains("Number of words: 4"));
    }

    @Test
    void main_twoArgs_throwsException() {
        Exception exception = assertThrows(CriticalAppException.class, () ->
                WordCount.main(new String[]{"one", "two"}));

        assertEquals("Error. Only one argument supported", exception.getMessage());
    }
}