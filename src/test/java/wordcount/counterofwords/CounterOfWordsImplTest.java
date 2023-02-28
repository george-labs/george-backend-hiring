package wordcount.counterofwords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CounterOfWordsImplTest {

    private CounterOfWordsImpl counter;
    private final List<String> stopWords = List.of("the", "a", "on", "off");

    @BeforeEach
    void setUp() {
        counter = new CounterOfWordsImpl(stopWords);
    }

    @Test
    void count_fourWords() {
        assertEquals(4, counter.count("Mary had a little lamb"));
    }

    @Test
    void count_twoWordsAndANumber() {
        assertEquals(2, counter.count("one two 3"));
    }

    @Test
    void count_numberInTheMiddle() {
        assertEquals(3, counter.count("one two a3b"));
    }
}