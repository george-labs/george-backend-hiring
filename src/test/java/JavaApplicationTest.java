import dictionary.Dictionary;
import org.junit.jupiter.api.Test;
import textProcessing.*;
import wordFilter.AlphabeticWordFilter;
import wordFilter.StopWordFilter;
import wordsStats.WordCounter;
import wordsStats.WordUnique;
import wordsStats.WordsStas;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaApplicationTest {

    @Test
    public void DummyTest() {
        assertTrue(Boolean.TRUE);
    }

    public List<String> parseWordsFromConsole() {
        Scanner scanner = new Scanner(System.in);

        ConsoleLineReader consoleLineReader = new ConsoleLineReader(scanner);
        LineProcessor lineProcessor = new LineProcessor().addFilter(new AlphabeticWordFilter());
        String line = consoleLineReader.getLine();
        return lineProcessor.getWords(line);
    }

    public WordCounter prepareWordCounterForAlphabeticWordsTests() {
        Scanner scanner = new Scanner(System.in);

        ConsoleLineReader consoleLineReader = new ConsoleLineReader(scanner);
        LineProcessor lineProcessor = new LineProcessor();
        lineProcessor.addFilter(new AlphabeticWordFilter()).addFilter(new AlphabeticWordFilter());
        WordFetcher wordFetcher = new WordFetcher(consoleLineReader, lineProcessor);
        WordCounter wordCounter = new WordCounter();
        WordsStas wordStats = new WordsStas(wordFetcher).addOperation(wordCounter);
        wordStats.generateStats();
        return wordCounter;
    }

    public WordCounter prepareWordCounterForStopWordsTests() {
        Scanner scanner = new Scanner(System.in);
        ConsoleLineReader consoleLineReader = new ConsoleLineReader(scanner);
        LineReader stopWordReader = null;
        try {
            stopWordReader = new FileLineReader(new Scanner(new File("stopwords.txt")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Dictionary stopWordsDict = new Dictionary(stopWordReader);
        LineProcessor lineProcessor = new LineProcessor().addFilter(new AlphabeticWordFilter()).addFilter(new StopWordFilter(stopWordsDict));
        WordFetcher wordFetcher = new WordFetcher(consoleLineReader, lineProcessor);
        WordCounter wordCounter = new WordCounter();
        WordsStas wordsStas = new  WordsStas(wordFetcher).addOperation(wordCounter);
        wordsStas.generateStats();
        return wordCounter;
    }

    public WordCounter prepareWordCounterForReadFromFile(StringReader sr){
        Scanner scanner = new Scanner(sr);
        LineReader lineReader = new FileLineReader(scanner);
        LineReader stopWordReader = null;
        try {
            stopWordReader = new FileLineReader(new Scanner(new File("stopwords.txt")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Dictionary stopWordsDict = new Dictionary(stopWordReader);
        LineProcessor lineProcessor = new LineProcessor().addFilter(new AlphabeticWordFilter()).addFilter(new StopWordFilter(stopWordsDict));
        WordFetcher wordFetcher = new WordFetcher(lineReader, lineProcessor);
        WordCounter wordCounter = new WordCounter();
        WordsStas wordsStas = new WordsStas(wordFetcher).addOperation(wordCounter);
        wordsStas.generateStats();
        return wordCounter;
    }


    @Test
    public void parseCorrectWordsFromConsole() {
        InputStream in = new ByteArrayInputStream("Aleksa is my name".getBytes());
        System.setIn(in);
        List<String> words = parseWordsFromConsole();
        assertEquals(List.of("Aleksa", "is", "my", "name"), words);
    }

    @Test
    public void parseWordsFromConsoleWithWhiteSpaces() {
        InputStream in = new ByteArrayInputStream("  Aleksa is my name ".getBytes());
        System.setIn(in);
        List<String> words = parseWordsFromConsole();
        assertEquals(List.of("Aleksa", "is", "my", "name"), words);
    }

    @Test
    public void parseWordsFromConsoleWithNonAlphabetic() {
        InputStream in = new ByteArrayInputStream("Aleksa33 is my3 name".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        List<String> words = parseWordsFromConsole();
        assertEquals(List.of("is", "name"), words);
    }

    @Test
    public void countWordsFromConsole() {
        InputStream in = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        System.setIn(in);
        WordCounter wordCounter = prepareWordCounterForAlphabeticWordsTests();
        assertEquals(5, wordCounter.getStat());
    }

    @Test
    public void countWordsWithNumbersFromConsole() {
        InputStream in = new ByteArrayInputStream("Mary had3 a little3 lamb".getBytes());
        System.setIn(in);
        WordCounter wordCounter = prepareWordCounterForAlphabeticWordsTests();
        assertEquals(3, wordCounter.getStat());
    }

    @Test
    public void countNoWordsFromConsole() {
        InputStream in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);
        WordCounter wordCounter = prepareWordCounterForAlphabeticWordsTests();
        assertEquals(0, wordCounter.getStat());
    }

    @Test
    public void countBlanksFromConsole() {
        InputStream in = new ByteArrayInputStream("    ".getBytes());
        System.setIn(in);
        WordCounter wordCounter = prepareWordCounterForAlphabeticWordsTests();
        assertEquals(0, wordCounter.getStat());
    }

    @Test
    public void countWordsWithStopWordsAndNumbersFromConsole() {
        InputStream in = new ByteArrayInputStream("Mary had a little3 lamb".getBytes());
        System.setIn(in);
        WordCounter wordCounter = prepareWordCounterForStopWordsTests();
        assertEquals(3, wordCounter.getStat());
    }

    @Test
    public void countWordsWithAllStopWordsFromConsole() {
        InputStream in = new ByteArrayInputStream("the a on off".getBytes());
        System.setIn(in);
        WordCounter wordCounter = prepareWordCounterForStopWordsTests();
        assertEquals(0, wordCounter.getStat());
    }

    @Test
    public void countWordsFromFile() {
        StringReader sr = new StringReader("Mary had\na little\nlamb\n");
        WordCounter wordCounter = prepareWordCounterForReadFromFile(sr);
        assertEquals(4, wordCounter.getStat());
    }

    @Test
    public void countWordsAllStopWordsFromFile() {
        StringReader sr = new StringReader("The a\nA\n");
        WordCounter wordCounter = prepareWordCounterForReadFromFile(sr);
        assertEquals(0, wordCounter.getStat());
    }
    @Test
    public void countWordsEmptyFile() {
        StringReader sr = new StringReader("");
        WordCounter wordCounter = prepareWordCounterForReadFromFile(sr);
        assertEquals(0, wordCounter.getStat());
    }

    @Test
    public void countWordsBlanksInFile() {
        StringReader sr = new StringReader("     \n  \n\n");
        WordCounter wordCounter = prepareWordCounterForReadFromFile(sr);
        assertEquals(0, wordCounter.getStat());
    }

    @Test
    public void countUniqueWordsFromConsole() {
        InputStream in = new ByteArrayInputStream("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        ConsoleLineReader consoleLineReader = new ConsoleLineReader(scanner);
        LineProcessor lineProcessor = new LineProcessor();
        LineReader stopWordReader = null;
        try {
            stopWordReader = new FileLineReader(new Scanner(new File("stopwords.txt")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Dictionary stopWordsDict = new Dictionary(stopWordReader);
        lineProcessor.addFilter(new AlphabeticWordFilter()).addFilter(new AlphabeticWordFilter()).addFilter(new StopWordFilter(stopWordsDict));
        WordFetcher wordFetcher = new WordFetcher(consoleLineReader, lineProcessor);
        WordCounter wordCounter = new WordCounter();
        WordUnique wordUnique = new WordUnique();
        WordsStas wordStats = new WordsStas(wordFetcher).addOperation(wordCounter).addOperation(wordUnique);
        wordStats.generateStats();

        assertEquals(6, wordUnique.getStat());
    }

    @Test
    public void countWordsWithHyphenFromConsole() {
        InputStream in = new ByteArrayInputStream("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.".getBytes());
        System.setIn(in);
        WordCounter wordCounter = prepareWordCounterForStopWordsTests();
        assertEquals(7, wordCounter.getStat());
    }
}
