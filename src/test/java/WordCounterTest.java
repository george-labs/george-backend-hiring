import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WordCounterTest {

    @Test
    public void testBasic() {
        List<String> input = new ArrayList<>(List.of("Mary had a little lamb"));

        long result = WordCounterFactory.createWithDefaultStopWords(input).count();

        Assertions.assertEquals(4, result);
    }


    @Test
    public void testNumberNotAWord() {
        List<String> input = new ArrayList<>(List.of("Mary had a 5 lambs"));

        long result = WordCounterFactory.createWithDefaultStopWords(input).count();

        Assertions.assertEquals(result, 3);
    }

    @Test
    public void testNoWords() {
        List<String> input = new ArrayList<>(List.of(""));

        long result = WordCounterFactory.createWithDefaultStopWords(input).count();

        Assertions.assertEquals(result, 0);
    }

    @Test
    public void testWordsWithNumbersIgnored() {
        List<String> input = new ArrayList<>(List.of("M4ry h4s five lambs"));

        long result = WordCounterFactory.createWithDefaultStopWords(input).count();

        Assertions.assertEquals(result, 2);
    }


    @Test
    public void testStopWordsAreIgnored() {
        List<String> input = new ArrayList<>(List.of("random the text something a on off"));

        long result = WordCounterFactory.createWithDefaultStopWords(input).count();

        Assertions.assertEquals(result, 3);
    }


    @Test
    public void testMultipleLines() {
        List<String> input = new ArrayList<>(List.of("Mary had", "a", "little lamb"));

        long result = WordCounterFactory.createWithDefaultStopWords(input).count();

        Assertions.assertEquals(4, result);
    }


    @Test
    public void testUniqueWords() {
        List<String> input = new ArrayList<>(List.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."));

        WordCounter wordCounter = WordCounterFactory.createWithDefaultStopWords(input);

        Assertions.assertEquals(9, wordCounter.count());
        Assertions.assertEquals(7, wordCounter.unique());

    }
}
