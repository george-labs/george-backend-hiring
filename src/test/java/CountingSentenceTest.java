
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class CountingSentenceTest {
    private Sentence sentence;

    @BeforeEach
    void setUp() {
        sentence = new Sentence();
    }

    @Test
    void countingWordsInSentenceWithEmptySpacesAtBeginningTest() {

        assertEquals(1, sentence.countingWordsOnlyLetter("     word     "));
    }

    @Test
    void countingWordsWithoutEmptySpacesAndNumbersTest() {

        assertEquals(1, sentence.countingWordsOnlyLetter("word"));
    }

    @Test
    void countingWordsWithThreeWordInSentenceTest(){

        assertEquals(3, sentence.countingWordsOnlyLetter("word word word"));
    }

    @Test
    void countingWordsWithNumbersInSentenceTest() {

        assertEquals(2, sentence.countingWordsOnlyLetter("wor3d word word"));
    }
    @Test
    void countingWordsWithSpecialCasesTest(){

        assertEquals(1, sentence.countingWordsOnlyLetter("wo$$d word"));
    }

    @Test
    void countingWordsWithComasDotsAndQuestionMarksCasesTest(){

        assertEquals(1, sentence.countingWordsOnlyLetter("word. word, word? word! word"));
    }

    @Test
    void countingWordsWithEmptyStringCasesTest(){

        assertEquals(0, sentence.countingWordsOnlyLetter(""));
    }
}
