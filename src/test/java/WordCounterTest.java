import org.junit.jupiter.api.Test;

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
}