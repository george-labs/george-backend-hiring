import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void test_happy_path() {
        var input = List.of("Mary", "had", "a", "little", "lamb");

        var wordProcessor = new WordCounter();
        wordProcessor.processString(input);

        assertEquals(5, wordProcessor.getWordCount());
    }

    @Test
    public void test_non_words() {
        var input = List.of("M4ry", "_had", "a", "l1ttle", "l-a-m-b");

        var wordProcessor = new WordCounter();
        wordProcessor.processString(input);

        assertEquals(1, wordProcessor.getWordCount());
    }

    @Test
    public void test_whitespace() {
        var input = List.of("foo ", " bar", " baz ");

        var wordProcessor = new WordCounter();
        wordProcessor.processString(input);

        assertEquals(0, wordProcessor.getWordCount());
    }
}
