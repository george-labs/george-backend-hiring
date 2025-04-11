package counter;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import service.counter.WordCounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

        @Test
        void countWordsTest9Words7Unique() {
            String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
            WordCounter wordCounter = new WordCounter();
            assertEquals(7, wordCounter.countWords(input));
            assertEquals(6, wordCounter.countUniqueWords(input));
        }

        @Test
        void countWordsTest9Words7Unique1Filtered() {
            String input = "Humpty-Dumpty s4t on a wall. Humpty-Dumpty had a great fall.";
            WordCounter wordCounter = new WordCounter();
            assertEquals(6, wordCounter.countWords(input));
            assertEquals(5, wordCounter.countUniqueWords(input));
        }

        @Test
        void countWordsTestNull() {
            WordCounter wordCounter = new WordCounter();
            assertEquals(0, wordCounter.countWords(null));
            assertEquals(0, wordCounter.countUniqueWords(null));
        }

        @Test
        void countWordsTestEmptyString() {
            WordCounter wordCounter = new WordCounter();
            assertEquals(0, wordCounter.countWords(""));
            assertEquals(0, wordCounter.countUniqueWords(""));
        }

        @Test
        void calculateAverageWordLengthTest() {
            WordCounter wordCounter = new WordCounter();
            assertEquals(7.50f, wordCounter.calculateAverageWordLength("worddddddd wordd"));
        }


}
