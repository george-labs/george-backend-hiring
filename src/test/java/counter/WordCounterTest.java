package counter;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import service.counter.WordCounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Nested
    public class CountWordsTest {
        @Test
        void countWordsTest5Words() {
            WordCounter wordCounter = new WordCounter();
            assertEquals(5, wordCounter.countWords("Mary had a little lamb"));
        }

        @Test
        void countWordsTest1Filtered() {
            WordCounter wordCounter = new WordCounter();
            assertEquals(4, wordCounter.countWords("M4ry had a little lamb"));
        }

        @Test
        void countWordsTestNull() {
            WordCounter wordCounter = new WordCounter();
            assertEquals(0, wordCounter.countWords(null));
        }

        @Test
        void countWordsTestEmptyString() {
            WordCounter wordCounter = new WordCounter();
            assertEquals(0, wordCounter.countWords(""));
        }
    }

    @Nested
    public class CountWordsWithStopWordsTest {

        @Test
        void countWordsWithStopWordsTest5Words() {
            WordCounter wordCounter = new WordCounter();
            assertEquals(4, wordCounter.countWordsWithStopWords("Mary had a little lamb"));
        }

        @Test
        void countWordsWithStopWordsTest1Filtered() {
            WordCounter wordCounter = new WordCounter();
            assertEquals(3, wordCounter.countWordsWithStopWords("M4ry had a little lamb"));
        }

        @Test
        void countWordsWithStopWordsTestNull() {
            WordCounter wordCounter = new WordCounter();
            assertEquals(0, wordCounter.countWordsWithStopWords(null));
        }

        @Test
        void countWordsWithStopWordsTestEmptyString() {
            WordCounter wordCounter = new WordCounter();
            assertEquals(0, wordCounter.countWordsWithStopWords(""));
        }
    }
}
