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
        assertEquals(0, result.wordCount());
        assertEquals(0, result.uniqueWordCount());
        assertEquals(0, result.avgLength());
    }

    @Test
    public void countWords_whenTextIsBlank() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords(" ");
        assertEquals(0, result.wordCount());
        assertEquals(0, result.uniqueWordCount());
        assertEquals(0, result.avgLength());
    }

    @Test
    public void countWords_whenNormalText() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("asdf asdfasdf asdfdf");
        assertEquals(3, result.wordCount());
        assertEquals(3, result.uniqueWordCount());
        assertEquals(6, result.avgLength());
    }

    @Test
    public void countWords_whenTextHasHyphen() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("Humpty-Dumpty sat on a wall. Have a great fall.");
        assertEquals(6, result.wordCount());
        assertEquals(6, result.uniqueWordCount());
    }

    @Test
    public void countWords_whenTextHasDuplication() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("Humpty Dumpty sat on a wall. Have Dumpty a great fall.");
        assertEquals(8, result.wordCount());
        assertEquals(7, result.uniqueWordCount());
    }

    @Test
    public void countWords_whenTextHasHyphenAndDuplicate() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        assertEquals(7, result.wordCount());
        assertEquals(6, result.uniqueWordCount());
    }

    @Test
    public void countWords_whenTextAndStopWord() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("asdf asdfa324sdf on asdfdf");
        assertEquals(2, result.wordCount());
        assertEquals(2, result.uniqueWordCount());
    }

    @Test
    public void countWords_whenTextAndStopWordsOnly() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("off on");
        assertEquals(0, result.wordCount());
        assertEquals(0, result.uniqueWordCount());
    }

    @Test
    public void countWords_whenAndStopWordAndBlank() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("off on  ");
        assertEquals(0, result.wordCount());
        assertEquals(0, result.uniqueWordCount());
    }

    @Test
    public void countWords_whenStopWordsAndNumber() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTest);
        WordCountStat result = wordCounter.countWords("off on 9879");
        assertEquals(0, result.wordCount());
        assertEquals(0, result.uniqueWordCount());
    }

    @Test
    public void countWords_whenStopWordFileIsEmpty() {
        WordCounter wordCounter = new WordCounter(stopWordFilterTestEmpty);
        WordCountStat result = wordCounter.countWords("off asdf on asdfasdf asdfdf");
        assertEquals(5, result.wordCount());
        assertEquals(5, result.uniqueWordCount());
    }
}
