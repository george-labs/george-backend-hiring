package sk.erste.wordcountkata;

import org.junit.jupiter.api.Test;
import sk.erste.wordcountkata.WordCounter.WordCountStat;
import sk.erste.wordcountkata.filter.StopWordFilter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private final StopWordFilter stopWordFilterTest = new StopWordFilter("stopwords_test.txt");
    private final StopWordFilter stopWordFilterTestEmpty = new StopWordFilter("stopwords_test_empty.txt");

    @Test
    public void countWords_whenTextIsEmpty() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("");
        assertEquals(new WordCountStat(0, 0), result);
    }

    @Test
    public void countWords_whenTextIsBlank() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords(" ");
        assertEquals(new WordCountStat(0, 0), result);
    }

    @Test
    public void countWords_whenNormalText() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("asdf asdfasdf asdfdf");
        assertEquals(new WordCountStat(3, 3), result);
    }

    @Test
    public void countWords_whenTextHasHyphen() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("Humpty-Dumpty sat on a wall. Have a great fall.");
        assertEquals(new WordCountStat(7, 7), result);
    }

    @Test
    public void countWords_whenTextHasDuplication() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("Humpty Dumpty sat on a wall. Have Dumpty a great fall.");
        assertEquals(new WordCountStat(8, 7), result);
    }

    @Test
    public void countWords_whenTextHasHyphenAndDuplicate() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        assertEquals(new WordCountStat(9, 7), result);
    }

    @Test
    public void countWords_whenTextAndStopWord() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("asdf asdfa324sdf on asdfdf");
        assertEquals(new WordCountStat(2, 2), result);
    }

    @Test
    public void countWords_whenTextAndStopWordsOnly() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("off on");
        assertEquals(new WordCountStat(0, 0), result);
    }

    @Test
    public void countWords_whenAndStopWordAndBlank() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("off on  ");
        assertEquals(new WordCountStat(0, 0), result);
    }

    @Test
    public void countWords_whenStopWordsAndNumber() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("off on 9879");
        assertEquals(new WordCountStat(0, 0), result);
    }

    @Test
    public void countWords_whenStopWordFileIsEmpty() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTestEmpty);
        WordCountStat result = wordCounter.countWords("off asdf on asdfasdf asdfdf");
        assertEquals(new WordCountStat(5, 5), result);
    }
}
