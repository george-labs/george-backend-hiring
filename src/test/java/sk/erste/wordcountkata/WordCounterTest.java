package sk.erste.wordcountkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private final StopWordFilter stopWordFilterTest = new StopWordFilter("stopwords_test.txt");
    private final StopWordFilter stopWordFilterTestEmpty = new StopWordFilter("stopwords_test_empty.txt");

    @Test
    public void countWords_whenTextIsEmpty() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        int result = wordCounter.countWords("");
        assertEquals(0, result);
    }

    @Test
    public void countWords_whenTextIsBlank() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        int result = wordCounter.countWords(" ");
        assertEquals(0, result);
    }

    @Test
    public void countWords_whenText() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        int result = wordCounter.countWords("asdf asdfasdf asdfdf");
        assertEquals(3, result);
    }

    @Test
    public void countWords_whenText2() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        int result = wordCounter.countWords("asdf asdfa324sdf asdfdf");
        assertEquals(2, result);
    }

    @Test
    public void countWords_whenTextAndStopWord() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        int result = wordCounter.countWords("asdf asdfa324sdf on asdfdf");
        assertEquals(2, result);
    }

    @Test
    public void countWords_whenTextAndStopWordsOnly() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        int result = wordCounter.countWords("off on");
        assertEquals(0, result);
    }

    @Test
    public void countWords_whenAndStopWordAndBlank() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        int result = wordCounter.countWords("off on  ");
        assertEquals(0, result);
    }

    @Test
    public void countWords_whenStopWordsAndNumber() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        int result = wordCounter.countWords("off on 9879");
        assertEquals(0, result);
    }

    @Test
    public void countWords_whenStopWordFileIsEmpty() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTestEmpty);
        int result = wordCounter.countWords("off asdf on asdfasdf asdfdf");
        assertEquals(5, result);
    }
}
