package wordcounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class WordCounterTest {

    WordCounter wordCounter = new WordCounter(Set.of(""));

    @Test
    void countWords() {
        String helloWorld = "Hello World";
        int result = wordCounter.countWords(helloWorld);
        Assertions.assertEquals(2, result);
    }

    @Test
    void countWords_withIllegalCharacter() {
        String helloWorld = "Hello World! 123 !";
        int result = wordCounter.countWords(helloWorld);
        Assertions.assertEquals(1, result);
    }

    @Test
    void countWords_null() {
        Assertions.assertThrows(NullPointerException.class, () -> wordCounter.countWords(null));
    }

    @Test
    void countWords_checkStopwords() {
        wordCounter = new WordCounter(Set.of("of", "and", "a"));
        String input = "This is a test of WordCounter";
        int result = wordCounter.countWords(input);
        Assertions.assertEquals(4, result);
    }

}