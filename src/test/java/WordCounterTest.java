import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    public WordCounter underTest;

    @Test
    public void testCountWords() {
        underTest = new WordCounter("Mary had a little lamb");

        assertEquals(5, underTest.countWords());
    }

    @Test
    public void testCountWordsWithNumbers() {
        underTest = new WordCounter("Mary had 5 little lambs");

        assertEquals(4, underTest.countWords());
    }

    @Test
    public void testCountWordsWithForbiddenWords() {
        List<String> forbiddenWords = Arrays.asList("Mary", "had");

        underTest = new WordCounter("Mary had 5 little lambs", forbiddenWords);

        assertEquals(2, underTest.countWords());
    }

    @Test
    public void testCountUniqueWordsWithoutHyphen() {
        List<String> forbiddenWords = Arrays.asList("the", "a", "on", "off");

        underTest = new WordCounter("Humpty Dumpty sat on a wall. Humpty Dumpty had a great fall.", forbiddenWords);

        assertEquals(9, underTest.countWords());
        assertEquals(7, underTest.countUniqueWords());
    }

    @Test
    public void testCountUniqueWordsWithHyphen() {
        List<String> forbiddenWords = Arrays.asList("the", "a", "on", "off");

        underTest = new WordCounter("Humpty-Dumpty sat on a wall - Humpty-Dumpty had a great fall.", forbiddenWords);

        assertEquals(7, underTest.countWords());
        assertEquals(6, underTest.countUniqueWords());
    }
}