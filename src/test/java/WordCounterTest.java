import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void test_happy_path() {
        var wordProcessor = new WordCounter("Mary had a little lamb");
        wordProcessor.processString();

        assertEquals(5, wordProcessor.getWordCount());
    }

    @Test
    public void test_non_words() {
        var wordProcessor = new WordCounter("M4ry _had a l1ttle l-a-m-b");
        wordProcessor.processString();

        assertEquals(1, wordProcessor.getWordCount());
    }

    @Test
    public void test_trailing_whitespace() {
        var wordProcessor = new WordCounter("foo bar baz ");
        wordProcessor.processString();

        assertEquals(3, wordProcessor.getWordCount());
    }

    @Test
    public void test_leading_whitespace() {
        var wordProcessor = new WordCounter(" foo bar baz");
        wordProcessor.processString();

        assertEquals(3, wordProcessor.getWordCount());
    }

}
