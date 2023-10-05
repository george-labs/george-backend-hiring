package counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {

    @Test
    public void wordCounterCountMustReturnNumberOfWords() {
        String inputText = "Mary had a little lamb";
        WordCounter wordCounter = new WordCounter("");

        int numberOfWords = wordCounter.count(inputText);

        Assertions.assertEquals(5, numberOfWords, "Word counter did not return the right amount of words.");
    }

    @Test
    public void wordCounterCountMustNotCountSpecialChars() {
        String inputText = "Mary had a little lamb ,,, ;;; 123 abc";
        WordCounter wordCounter = new WordCounter("");

        int numberOfWords = wordCounter.count(inputText);

        Assertions.assertEquals(6, numberOfWords, "Word counter did not return the right amount of words.");
    }

    @Test
    public void wordCounterMustHandleEmptyString() {
        String inputText = "";
        WordCounter wordCounter = new WordCounter("");

        int numberOfWords = wordCounter.count(inputText);

        Assertions.assertEquals(0, numberOfWords, "Word counter did not return the right amount of words.");
    }

    @Test
    public void wordCounterMustIgnoreStopwords() {
        String inputText = "Mary had a the little lamb";
        WordCounter wordCounter = new WordCounter("the,a");

        int numberOfWords = wordCounter.count(inputText);

        Assertions.assertEquals(4, numberOfWords, "Word counter did not return the right amount of words.");
    }

    @Test
    public void wordCounterMustHandleEmptyStopwords() {
        String inputText = "Mary had a the little lamb";
        WordCounter wordCounter = new WordCounter("");

        int numberOfWords = wordCounter.count(inputText);

        Assertions.assertEquals(6, numberOfWords, "Word counter did not return the right amount of words.");
    }
}
