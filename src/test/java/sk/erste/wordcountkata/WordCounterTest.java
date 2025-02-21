package sk.erste.wordcountkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void countWords_whenTextIsEmpty_returnZero() {
        WordCounter wordCounter = new WordCounter("");
        int result = wordCounter.countWords();
        assertEquals(0, result);
    }

    @Test
    public void countWords_whenTextIsBlank_returnZero() {
        WordCounter wordCounter = new WordCounter(" ");
        int result = wordCounter.countWords();
        assertEquals(0, result);
    }

    @Test
    public void countWords_whenText_return() {
        WordCounter wordCounter = new WordCounter("asdf asdfasdf asdfdf");
        int result = wordCounter.countWords();
        assertEquals(3, result);
    }

    @Test
    public void countWords_whenText2_return() {
        WordCounter wordCounter = new WordCounter("asdf asdfa324sdf asdfdf");
        int result = wordCounter.countWords();
        assertEquals(2, result);
    }
}
