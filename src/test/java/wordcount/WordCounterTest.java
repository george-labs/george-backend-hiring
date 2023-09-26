package wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordCounterTest {
    private static final List<String> INPUT_WORDS = List.of("Mary", "had", "a", "little", "lamb");
    private static final List<String> STOP_WORDS = List.of("the", "a", "on", "off");


    @Test
    public void testWordCountNoStopWords() {
        int count = new WordCounter().countNumberOfWords(INPUT_WORDS);

        Assertions.assertEquals(5, count);
    }

    @Test
    public void testWordCountUseStopWords() {
        int count = new WordCounter(STOP_WORDS).countNumberOfWords(INPUT_WORDS);

        Assertions.assertEquals(4, count);
    }
}
