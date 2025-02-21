package sk.erste.wordcountkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordFilterTest {
    @Test
    public void isWordValid_whenWord_returnTrue() {
        WordFilter wordFilter = new WordFilter("word");
        assertTrue(wordFilter.isWordValid());
    }

    @Test
    public void isWordValid_whenContainsNumbers_returnFalse() {
        WordFilter wordFilter = new WordFilter("wo34rd");
        assertFalse(wordFilter.isWordValid());
    }

    @Test
    public void isWordValid_whenNull_returnFalse() {
        WordFilter wordFilter = new WordFilter(null);
        assertFalse(wordFilter.isWordValid());
    }

    @Test
    public void isWordValid_whenEmpty_returnFalse() {
        WordFilter wordFilter = new WordFilter("");
        assertFalse(wordFilter.isWordValid());
    }

    @Test
    public void isWordValid_whenBlank_returnFalse() {
        WordFilter wordFilter = new WordFilter(" ");
        assertFalse(wordFilter.isWordValid());
    }
}
