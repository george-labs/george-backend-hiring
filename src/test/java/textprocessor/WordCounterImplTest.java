package textprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterImplTest {

    @Test
    void testSingleWord() {
        WordsCounter wordCounter = new WordCounterImpl();

        int count = wordCounter.countWords("Mary");
        Assertions.assertEquals(1, count);
    }

    @Test
    void testMultiWord() {
        WordsCounter wordCounter = new WordCounterImpl();

        int count = wordCounter.countWords("Mary had a little lamb");
        Assertions.assertEquals(5, count);
    }

    @Test
    void testEmptyText() {
        WordsCounter wordCounter = new WordCounterImpl();

        int count = wordCounter.countWords("");
        Assertions.assertEquals(0, count);
    }

    @Test
    void testWhitespaceText() {
        WordsCounter wordCounter = new WordCounterImpl();

        int count = wordCounter.countWords("          ");
        Assertions.assertEquals(0, count);
    }

    @Test
    void testTextDigitsAndSymbols() {
        WordsCounter wordCounter = new WordCounterImpl();

        int count = wordCounter.countWords("AA$BB   CC5DD 1234 @#$% XXX YYY");
        Assertions.assertEquals(6, count);
    }
}
