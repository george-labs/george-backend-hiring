import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordCountTest {

    @Test
    void getNumberOfWordsTest_withoutStopWords() {
        WordCounter testCounter = new WordCounter();

        final var maryResult = testCounter.getNumberOfWords("Mary had a little lamb");
        final var quoteResult = testCounter.getNumberOfWords("To be free is to have achieved your life");

        Assertions.assertEquals(5, maryResult);
        Assertions.assertEquals(9, quoteResult);
    }

    @Test
    void getNumberOfWordsTest_withStopWords() {
        WordCounter testCounter = new WordCounter(List.of("a", "of","the"));

        final var maryResult = testCounter.getNumberOfWords("Mary had a little lamb");
        final var quoteResult = testCounter.getNumberOfWords("To be free is to have achieved your life");

        Assertions.assertEquals(4, maryResult);
        Assertions.assertEquals(9, quoteResult);
    }
}
