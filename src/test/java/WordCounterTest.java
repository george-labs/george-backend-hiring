import exception.IterationException;
import org.junit.jupiter.api.Test;
import process.StopWordFilter;
import process.WordCounter;
import process.WordFilter;
import read.ConsoleReader;
import read.FileReader;
import read.Reader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordCounterTest {

    @Test
    void testCount_whenEmptySentence_returnIterationException() throws IOException {
        String sentence = "";
        String fileName = "stopwords.txt";
        FileReader fileReader = new FileReader(fileName);
        ConsoleReader wordReader = new ConsoleReader(sentence);
        WordFilter wordFilter = new StopWordFilter(wordReader, fileReader);
        WordCounter wordCounter = new WordCounter(wordFilter);

        assertThrows(IterationException.class, wordCounter::count);
    }

    @Test
    void testCount_whenCorrectSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary had a little lamb";
        String fileName = "src/test/resources/stopwords.txt";
        ConsoleReader inputReader = new ConsoleReader(sentence);
        FileReader stopWordReader = new FileReader(fileName);
        StopWordFilter stopWordFilter = new StopWordFilter(stopWordReader, inputReader);
        WordCounter wordCounter = new WordCounter(stopWordFilter);

        int count = wordCounter.count();

        assertEquals(4, count);
    }

    @Test
    void testCount_whenDuplicateWordInSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary had had a little lamb lamb";
        String fileName = "src/test/resources/stopwords.txt";
        ConsoleReader inputReader = new ConsoleReader(sentence);
        FileReader stopWordReader = new FileReader(fileName);
        StopWordFilter stopWordFilter = new StopWordFilter(stopWordReader, inputReader);
        WordCounter wordCounter = new WordCounter(stopWordFilter);

        int count = wordCounter.count();

        assertEquals(6, count);
    }

    @Test
    void testCount_whenDuplicateStopWordInSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary had the little the lamb";
        String fileName = "src/test/resources/stopwords.txt";
        ConsoleReader inputReader = new ConsoleReader(sentence);
        Reader stopWordReader = new FileReader(fileName);
        StopWordFilter stopWordFilter = new StopWordFilter(stopWordReader, inputReader);
        WordCounter wordCounter = new WordCounter(stopWordFilter);

        int count = wordCounter.count();

        assertEquals(4, count);
    }

    @Test
    void testCount_whenExtraCharactersInSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary, had a little lamb.";
        String fileName = "src/test/resources/stopwords.txt";
        ConsoleReader inputReader = new ConsoleReader(sentence);
        FileReader stopWordReader = new FileReader(fileName);
        StopWordFilter stopWordFilter = new StopWordFilter(stopWordReader, inputReader);
        WordCounter wordCounter = new WordCounter(stopWordFilter);

        int count = wordCounter.count();

        assertEquals(4, count);
    }

    @Test
    void testCount_whenExtraCharactersInStopWordsInSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary had a, little lamb.";
        String fileName = "src/test/resources/stopwords.txt";
        ConsoleReader inputReader = new ConsoleReader(sentence);
        FileReader stopWordReader = new FileReader(fileName);
        StopWordFilter stopWordFilter = new StopWordFilter(stopWordReader, inputReader);
        WordCounter wordCounter = new WordCounter(stopWordFilter);

        int count = wordCounter.count();

        assertEquals(4, count);
    }
}
