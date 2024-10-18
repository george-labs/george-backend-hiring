import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static constant.TestConstant.TEST_MARY_TEXT;
import static constant.TestConstant.TEST_QUOTE_TEXT;

class WordCountTest {


    @Test
    void getNumberOfWordsTest() {
        WordCounter testCounter = new WordCounter();

        final var maryResult = testCounter.getNumberOfWords(TEST_MARY_TEXT);
        final var quoteResult = testCounter.getNumberOfWords(TEST_QUOTE_TEXT);

        Assertions.assertEquals(5, maryResult);
        Assertions.assertEquals(9, quoteResult);
    }

}
