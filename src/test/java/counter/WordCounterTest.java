package counter;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import service.counter.Counter;
import service.counter.WordCounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Nested
    public class CountWordsTest {
        @Test
        void countWordsTest5Words() {
            Counter wordCounter = new WordCounter();
            assertEquals(5, wordCounter.countWords("Mary had a little lamb"));
        }

        @Test
        void countWordsTest1Filtered() {
            Counter wordCounter = new WordCounter();
            assertEquals(4, wordCounter.countWords("M4ry had a little lamb"));
        }

        @Test
        void countWordsTestNull() {
            Counter wordCounter = new WordCounter();
            assertEquals(0, wordCounter.countWords(null));
        }

        @Test
        void countWordsTestEmptyString() {
            Counter wordCounter = new WordCounter();
            assertEquals(0, wordCounter.countWords(""));
        }
    }

    @Nested
    public class CountWordsWithStopWordsTest {

        @Test
        void countWordsWithStopWordsTest5Words() {
            Counter wordCounter = new WordCounter();
            assertEquals(4, wordCounter.countWordsWithStopWords("Mary had a little lamb"));
        }

        @Test
        void countWordsWithStopWordsTest1Filtered() {
            Counter wordCounter = new WordCounter();
            assertEquals(3, wordCounter.countWordsWithStopWords("M4ry had a little lamb"));
        }

        @Test
        void countWordsWithStopWordsTestNull() {
            Counter wordCounter = new WordCounter();
            assertEquals(0, wordCounter.countWordsWithStopWords(null));
        }

        @Test
        void countWordsWithStopWordsTestEmptyString() {
            Counter wordCounter = new WordCounter();
            assertEquals(0, wordCounter.countWordsWithStopWords(""));
        }
    }
}
