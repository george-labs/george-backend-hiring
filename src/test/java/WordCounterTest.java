import exception.IterationException;
import org.junit.jupiter.api.Test;
import process.StopWordFilter;
import process.WordCounter;
import process.WordFilter;
import read.FileReader;

import java.io.IOException;
import java.io.Reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordCounterTest {

    @Test
    void testCount_whenEmptySentence_returnIterationException() throws IOException {
        String sentence = "";
        String fileName = "stopwords.txt";
        FileReader stopWordReader = new FileReader(fileName);
        StopWordFilter stopWordFilter = new StopWordFilter(stopWordReader, )
        WordFilter wordFilter = new StopWordFilter()
        WordCounter wordCounter = new WordCounter();

        assertThrows(IterationException.class,
                () -> simpleWordCounter.count(sentence));
    }

    @Test
    void testCount_whenCorrectSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary had a little lamb";
        String fileName = "src/test/resources/stopwords.txt";
        SimpleWordCounter simpleWordCounter = new SimpleWordCounter(fileName);

        int count = simpleWordCounter.count(sentence);

        assertEquals(4, count);
    }

    @Test
    void testCount_whenDuplicateWordInSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary had had a little lamb lamb";
        String fileName = "src/test/resources/stopwords.txt";
        SimpleWordCounter simpleWordCounter = new SimpleWordCounter(fileName);

        int count = simpleWordCounter.count(sentence);

        assertEquals(6, count);
    }

    @Test
    void testCount_whenDuplicateStopWordInSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary had the little the lamb";
        String fileName = "src/test/resources/stopwords.txt";
        SimpleWordCounter simpleWordCounter = new SimpleWordCounter(fileName);

        int count = simpleWordCounter.count(sentence);

        assertEquals(4, count);
    }

    @Test
    void testCount_whenExtraCharactersInSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary, had a little lamb.";
        String fileName = "src/test/resources/stopwords.txt";
        SimpleWordCounter simpleWordCounter = new SimpleWordCounter(fileName);

        int count = simpleWordCounter.count(sentence);

        assertEquals(4, count);
    }

    @Test
    void testCount_whenExtraCharactersInStopWordsInSentence_returnExpectedResult() throws IOException, IterationException {
        String sentence = "Mary had a, little lamb.";
        String fileName = "src/test/resources/stopwords.txt";
        SimpleWordCounter simpleWordCounter = new SimpleWordCounter(fileName);

        int count = simpleWordCounter.count(sentence);

        assertEquals(4, count);
    }
}
