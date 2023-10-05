package counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {

    @Test
    public void wordCounterCountMustReturnNumberOfWords() {
        String inputText = "Mary had a little lamb";
        WordCounter wordCounter = new WordCounter("");

        CounterResult counterResult = wordCounter.process(inputText);

        Assertions.assertEquals(5, counterResult.getNumberOfWords(), "Word counter did not return the right amount of words.");
    }

    @Test
    public void wordCounterCountMustNotCountSpecialChars() {
        String inputText = "Mary had a little lamb ,,, ;;; 123 abc";
        WordCounter wordCounter = new WordCounter("");

        CounterResult counterResult = wordCounter.process(inputText);

        Assertions.assertEquals(6, counterResult.getNumberOfWords(), "Word counter did not return the right amount of words.");
    }

    @Test
    public void wordCounterMustHandleEmptyString() {
        String inputText = "";
        WordCounter wordCounter = new WordCounter("");

        CounterResult counterResult = wordCounter.process(inputText);

        Assertions.assertEquals(0, counterResult.getNumberOfWords(), "Word counter did not return the right amount of words.");
    }

    @Test
    public void wordCounterMustIgnoreStopwords() {
        String inputText = "Mary had a the little lamb";
        WordCounter wordCounter = new WordCounter("the,a");

        CounterResult counterResult = wordCounter.process(inputText);

        Assertions.assertEquals(4, counterResult.getNumberOfWords(), "Word counter did not return the right amount of words.");
    }

    @Test
    public void wordCounterMustHandleEmptyStopwords() {
        String inputText = "Mary had a the little lamb";
        WordCounter wordCounter = new WordCounter("");

        CounterResult counterResult = wordCounter.process(inputText);

        Assertions.assertEquals(6, counterResult.getNumberOfWords(), "Word counter did not return the right amount of words.");
    }

    @Test
    public void wordsEndingWithSpecialCharacterNeedToBeCounted() {
        String inputText = "Hello, World!";
        WordCounter wordCounter = new WordCounter("");

        CounterResult counterResult = wordCounter.process(inputText);

        Assertions.assertEquals(2, counterResult.getNumberOfWords(), "Word counter did not return the right amount of words.");
    }

    @Test
    public void uniqueWordsShouldBeShown() {
        String inputText = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        WordCounter wordCounter = new WordCounter("on,a");

        CounterResult counterResult = wordCounter.process(inputText);

        Assertions.assertEquals(7, counterResult.getNumberOfWords(), "Word counter did not return the right amount of words.");
        Assertions.assertEquals(6, counterResult.getNumberOfUniqueWords(), "Word counter did not return the right amount of unique words.");
    }
}
