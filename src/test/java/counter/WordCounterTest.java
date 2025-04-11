package counter;

import org.junit.jupiter.api.Test;
import service.counter.Counter;
import service.counter.WordCounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    void wordCounterTestCount5Words() {
        Counter wordCounter = new WordCounter();
        assertEquals(5, wordCounter.countWords("Mary had a little lamb"));
    }

    @Test
    void wordCounterTestCount4Words1Filtered() {
        Counter wordCounter = new WordCounter();
        assertEquals(4, wordCounter.countWords("M4ry had a little lamb"));
    }

    @Test
    void wordCounterTestCountNull() {
        Counter wordCounter = new WordCounter();
        assertEquals(0, wordCounter.countWords(null));
    }

    @Test
    void wordCounterTestCountEmptyString() {
        Counter wordCounter = new WordCounter();
        assertEquals(0, wordCounter.countWords(""));
    }
}
