import org.junit.jupiter.api.Test;
import textProcessing.ConsoleLineReader;
import textProcessing.LineProcessor;

import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaApplicationTest {

    @Test
    public void DummyTest() {
        assertTrue(Boolean.TRUE);
    }

    @Test
    public void parseWordsFromConsole() {
        InputStream in = new ByteArrayInputStream("Aleksa is my name".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        ConsoleLineReader consoleLineReader = new ConsoleLineReader(scanner);
        LineProcessor lineProcessor = new LineProcessor();
        String line = consoleLineReader.getLine();
        List<String> words = lineProcessor.getWords(line);

        assertEquals(words, List.of("Aleksa", "is", "my", "name"));
    }

    @Test
    public void parseWordsFromConsoleWithWhiteSpaces() {
        InputStream in = new ByteArrayInputStream("  Aleksa is my name ".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        ConsoleLineReader consoleLineReader = new ConsoleLineReader(scanner);
        LineProcessor lineProcessor = new LineProcessor();
        String line = consoleLineReader.getLine();
        List<String> words = lineProcessor.getWords(line);

        assertEquals(words, List.of("Aleksa", "is", "my", "name"));
    }

    @Test
    public void parseWordsFromConsoleWithNonAlphabetic() {
        InputStream in = new ByteArrayInputStream("Aleksa33 is my3 name".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        ConsoleLineReader consoleLineReader = new ConsoleLineReader(scanner);
        LineProcessor lineProcessor = new LineProcessor();
        String line = consoleLineReader.getLine();
        List<String> words = lineProcessor.getWords(line);

        assertEquals(words, List.of("is", "name"));
    }
}
