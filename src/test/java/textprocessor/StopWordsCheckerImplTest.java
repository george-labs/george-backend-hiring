package textprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StopWordsCheckerImplTest {

    StopWordsChecker stopWordsChecker;

    private void init() {
        stopWordsChecker = new StopWordsCheckerImpl("src/test/resources/teststopwords.txt");
    }

    @Test
    void testStopWords() {
        init();

        Assertions.assertTrue(stopWordsChecker.isStopWord("the"));
        Assertions.assertTrue(stopWordsChecker.isStopWord("The"));
        Assertions.assertTrue(stopWordsChecker.isStopWord("a"));
        Assertions.assertTrue(stopWordsChecker.isStopWord("A"));

        Assertions.assertFalse(stopWordsChecker.isStopWord("word"));
        Assertions.assertFalse(stopWordsChecker.isStopWord("Aa"));
    }

    @Test
    void testNull() {
        init();

        Assertions.assertFalse(stopWordsChecker.isStopWord(null));
    }
}
