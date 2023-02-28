package wordcount.counterofwords;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterOfWordsImplTest {

    @Test
    void count() {
        var counter = new CounterOfWordsImpl();
        assertEquals(5, counter.count("Mary had a little lamb"));
    }
}