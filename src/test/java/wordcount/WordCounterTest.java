package wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordCounterTest {
    private static final List<String> INPUT_WORDS = List.of("Mary", "had", "a", "little", "lamb");
    private static final List<String> STOP_WORDS = List.of("the", "a", "on", "off");


    @Test
    public void testWordCountNoStopWords() {
        TextAnalytics result  = new WordCounter().countNumberOfWords(INPUT_WORDS);

        Assertions.assertEquals(5, result.getWordCount());
    }

    @Test
    public void testWordCountUseStopWords() {
        TextAnalytics result  = new WordCounter(STOP_WORDS).countNumberOfWords(INPUT_WORDS);

        Assertions.assertEquals(4, result.getWordCount());
    }


    @Test
    public void testUniqueWordCountNoStopWords() {
        TextAnalytics result  = new WordCounter().countNumberOfWords(INPUT_WORDS);

        Assertions.assertEquals(5, result.getUniqueWordCount());
    }

    @Test
    public void testUniqueWordCountUseStopWords() {
        TextAnalytics result  = new WordCounter(STOP_WORDS).countNumberOfWords(INPUT_WORDS);

        Assertions.assertEquals(4, result.getUniqueWordCount());
    }
}
