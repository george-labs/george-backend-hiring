package wordcount.counterofwords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CounterOfWordsImplTest {

    private CounterOfWordsImpl counter;

    @BeforeEach
    void setUp() {
        counter = new CounterOfWordsImpl();
    }

    @Test
    void count_fiveWords() {
        assertEquals(5, counter.count("Mary had a little lamb"));
    }

    @Test
    void count_twoWordsAndANumber() {
        assertEquals(2, counter.count("one two 3"));
    }

    @Test
    void count_numberInTheMiddle() {
        assertEquals(4, counter.count("one two a3b"));
    }
}