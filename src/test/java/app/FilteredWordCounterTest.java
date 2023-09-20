package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class FilteredWordCounterTest {

    private final FilteredWordCounter filteredWordCounter = new FilteredWordCounter(Set.of("the", "a", "on", "off"));

    @Test
    void Should_count_words_separated_by_whitecharacters() {
        assertEquals(2, filteredWordCounter.countWords("   hello hello     "));
        assertEquals(3, filteredWordCounter.countWords("hello hello  \uD83D\uDE12   g"));
        assertEquals(2, filteredWordCounter.countWords("hello wer2ty  wörd   g"));
    }

    @Test
    void Should_count_words_ignoring_some() {
        assertEquals(4, filteredWordCounter.countWords("Mary had a little lamb"));
        assertEquals(3, filteredWordCounter.countWords("   hello hello  the a on 654 there off   "));
    }

}
