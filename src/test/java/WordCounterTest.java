import org.junit.jupiter.api.Test;
import util.PrintResult;

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
    public void testCountWordsWithStopWords() {
        List<String> listOfStopWords = Arrays.asList("Mary", "had");

        underTest = new WordCounter("Mary had 5 little lambs", listOfStopWords);

        assertEquals(2, underTest.countWords());
    }

    @Test
    public void testCountUniqueWordsWithoutHyphen() {
        List<String> listOfStopWords = Arrays.asList("the", "a", "on", "off");

        underTest = new WordCounter("Humpty Dumpty sat on a wall. Humpty Dumpty had a great fall.", listOfStopWords);

        assertEquals(9, underTest.countWords());
        assertEquals(7, underTest.countUniqueWords());
    }

    @Test
    public void testCountUniqueWordsWithHyphen() {
        List<String> listOfStopWords = Arrays.asList("the", "a", "on", "off");

        underTest = new WordCounter("Humpty-Dumpty sat on a wall - Humpty-Dumpty had a great fall.", listOfStopWords);

        assertEquals(7, underTest.countWords());
        assertEquals(6, underTest.countUniqueWords());
    }

    @Test
    public void testAverageWordLength() {
        underTest = new WordCounter("Humpty Dumpty Mary");

        assertEquals(5.33, underTest.countAverageWordLength());
    }

    @Test
    public void testCountShouldReturnPrintResult() {
        PrintResult expected = new PrintResult(3, 3, 5.33);

        underTest = new WordCounter("Humpty Dumpty Mary");
        PrintResult actual = underTest.count();

        assertEquals(expected, actual);
    }
}