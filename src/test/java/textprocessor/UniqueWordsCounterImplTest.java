package textprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniqueWordsCounterImplTest {
    private UniqueWordsCounter wordCounter;

    private void init() {
        StopWordsChecker stopWordsChecker = new StopWordsCheckerImpl("src/test/resources/teststopwords.txt");
        wordCounter = new UniqueWordsCounterImpl(stopWordsChecker);
    }

    @Test
    void testUniqueWords() {
        init();

        WordsCount count = wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        Assertions.assertEquals(9, count.getCount());
        Assertions.assertEquals(7, count.getUniqueCount());
    }

}
