import org.junit.jupiter.api.Test;
import textProcessing.ConsoleLineReader;
import textProcessing.LineProcessor;
import textProcessing.WordFetcher;
import wordFilter.AlphabeticWordFilter;
import wordsStats.WordCounter;

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
        LineProcessor lineProcessor = new LineProcessor().addFilter(new AlphabeticWordFilter());
        String line = consoleLineReader.getLine();
        List<String> words = lineProcessor.getWords(line);

        assertEquals(List.of("is", "name"), words);
    }

    @Test
    public void countWordsFromConsole() {
        InputStream in = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        ConsoleLineReader consoleLineReader = new ConsoleLineReader(scanner);
        LineProcessor lineProcessor = new LineProcessor();
        lineProcessor.addFilter(new AlphabeticWordFilter()).addFilter(new AlphabeticWordFilter());
        WordFetcher wordFetcher = new WordFetcher(consoleLineReader, lineProcessor);
        WordCounter wordCounter = new WordCounter(wordFetcher);
        assertEquals(5, wordCounter.getCount());
    }

    @Test
    public void countWordsWithNumbersFromConsole() {
        InputStream in = new ByteArrayInputStream("Mary had3 a little3 lamb".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        ConsoleLineReader consoleLineReader = new ConsoleLineReader(scanner);
        LineProcessor lineProcessor = new LineProcessor().addFilter(new AlphabeticWordFilter());
        WordFetcher wordFetcher = new WordFetcher(consoleLineReader, lineProcessor);
        WordCounter wordCounter = new WordCounter(wordFetcher);
        assertEquals(3, wordCounter.getCount());
    }

    @Test
    public void countNoWordsFromConsole() {
        InputStream in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        ConsoleLineReader consoleLineReader = new ConsoleLineReader(scanner);
        LineProcessor lineProcessor = new LineProcessor().addFilter(new AlphabeticWordFilter());
        WordFetcher wordFetcher = new WordFetcher(consoleLineReader, lineProcessor);
        WordCounter wordCounter = new WordCounter(wordFetcher);
        assertEquals(0, wordCounter.getCount());
    }

    @Test
    public void countBlanksFromConsole() {
        InputStream in = new ByteArrayInputStream("    ".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        ConsoleLineReader consoleLineReader = new ConsoleLineReader(scanner);
        LineProcessor lineProcessor = new LineProcessor().addFilter(new AlphabeticWordFilter());
        WordFetcher wordFetcher = new WordFetcher(consoleLineReader, lineProcessor);
        WordCounter wordCounter = new WordCounter(wordFetcher);
        assertEquals(0, wordCounter.getCount());
    }
}
