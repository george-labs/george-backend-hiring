package textprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterImplTest {
    private WordsCounter wordCounter;

    private void init() {
        StopWordsChecker stopWordsChecker = new StopWordsCheckerImpl("src/test/resources/teststopwords.txt");
        wordCounter = new WordCounterImpl(stopWordsChecker);
    }

    @Test
    void testSingleWord() {
        init();

        int count = wordCounter.countWords("Mary");
        Assertions.assertEquals(1, count);
    }

    @Test
    void testMultiWord() {
        init();

        int count = wordCounter.countWords("Mary had a little lamb");
        Assertions.assertEquals(4, count);
    }

    @Test
    void testEmptyText() {
        init();

        int count = wordCounter.countWords("");
        Assertions.assertEquals(0, count);
    }

    @Test
    void testWhitespaceText() {
        init();

        int count = wordCounter.countWords("          ");
        Assertions.assertEquals(0, count);
    }

    @Test
    void testTextDigitsAndSymbols() {
        init();

        int count = wordCounter.countWords("AA$BB   CC5DD 1234 @#$% XXX YYY");
        Assertions.assertEquals(6, count);
    }

    @Test
    void testOnlyBlacklisted() {
        init();

        int count = wordCounter.countWords("the a on off");
        Assertions.assertEquals(0, count);
    }

}
