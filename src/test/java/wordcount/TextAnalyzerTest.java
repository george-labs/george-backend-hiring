package wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import text.TextAnalytics;

import java.util.List;

public class TextAnalyzerTest {
    private static final List<String> INPUT_WORDS = List.of("Mary", "had", "a", "little", "lamb");
    private static final List<String> STOP_WORDS = List.of("the", "a", "on", "off");


    @Test
    public void testWordCountNoStopWords() {
        TextAnalytics result  = new TextAnalyzer().analyzeWords(INPUT_WORDS);

        Assertions.assertEquals(5, result.getWordCount());
    }

    @Test
    public void testWordCountUseStopWords() {
        TextAnalytics result  = new TextAnalyzer(STOP_WORDS).analyzeWords(INPUT_WORDS);

        Assertions.assertEquals(4, result.getWordCount());
    }


    @Test
    public void testUniqueWordCountNoStopWords() {
        TextAnalytics result  = new TextAnalyzer().analyzeWords(INPUT_WORDS);

        Assertions.assertEquals(5, result.getUniqueWordCount());
    }

    @Test
    public void testUniqueWordCountUseStopWords() {
        TextAnalytics result  = new TextAnalyzer(STOP_WORDS).analyzeWords(INPUT_WORDS);

        Assertions.assertEquals(4, result.getUniqueWordCount());
    }


    @Test
    public void testAverageWordLengthCountNoStopWords() {
        TextAnalytics result  = new TextAnalyzer().analyzeWords(INPUT_WORDS);

        Assertions.assertEquals(3.6, result.getAverageWordLength());
    }

    @Test
    public void testAverageWordLengthCountUseStopWords() {
        TextAnalytics result  = new TextAnalyzer(STOP_WORDS).analyzeWords(INPUT_WORDS);

        Assertions.assertEquals(4.25, result.getAverageWordLength());
    }

    @Test
    public void testWordCountNoInput() {
        TextAnalytics result  = new TextAnalyzer(STOP_WORDS).analyzeWords(List.of());

        Assertions.assertEquals(new TextAnalytics(0, 0, 0.0, List.of()), result);
    }

    @Test
    public void testWordCountNullInput() {
        TextAnalytics result  = new TextAnalyzer(STOP_WORDS).analyzeWords(null);

        Assertions.assertEquals(new TextAnalytics(0, 0, 0.0, List.of()), result);
    }
}
