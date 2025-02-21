package sk.erste.wordcountkata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StopWordFilterTest {

    @Test
    public void testStopWordFilter_whenNoEmptyLines() {
        StopWordFilter stopWordFilter = new StopWordFilter("stopwords_test.txt");
        assertEquals(List.of("the", "a", "on", "off", "asdfadf"), stopWordFilter.getStopWords());
    }

    @Test
    public void testStopWordFilter_whenEmptyLines() {
        StopWordFilter stopWordFilter = new StopWordFilter("stopwords_test_emptylines.txt");
        assertEquals(List.of("the", "a", "on", "off", "asdfadf"), stopWordFilter.getStopWords());
    }

    @Test
    public void testStopWordFilter_whenEmpty() {
        StopWordFilter stopWordFilter = new StopWordFilter("stopwords_test_empty.txt");
        assertEquals(List.of(), stopWordFilter.getStopWords());
    }

    @Test
    public void testStopWordFilter_whenFileNotExists() {
        assertThrows(IllegalArgumentException.class, () -> new StopWordFilter("stopwords_test_notexists.txt"));
    }
}
