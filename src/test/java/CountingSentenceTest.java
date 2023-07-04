
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountingSentenceTest {
    private Sentence sentence;

    @BeforeEach
    void setUp() {
        sentence = new Sentence();
    }

    @Test
    public void countingWordsInSentenceWithEmptySpacesAtBeginingTest() {

        assertEquals(1, sentence.countingWordsOnlyLetter("     word     "));
    }

    @Test
    public void countingWordsWithoutEmptySpacesAndNumbersTest() {

        assertEquals(1, sentence.countingWordsOnlyLetter("word"));
    }

    @Test
    public void countingWordsWithThreeWordInSentenceTest(){

        assertEquals(3, sentence.countingWordsOnlyLetter("word word word"));
    }

    @Test
    public void countingWordsWithNumbersInSentence() {

        assertEquals(2, sentence.countingWordsOnlyLetter("wor3d word word"));
    }
    @Test
    public void countingWordsWithSpecialCasesTest(){

        assertEquals(1, sentence.countingWordsOnlyLetter("wo$$d word"));
    }

    @Test
    public void countingWordsWithComasDotsAndQuestionMarksCasesTest(){

        assertEquals(1, sentence.countingWordsOnlyLetter("word. word, word? word! word"));
    }

    @Test
    public void countingWordsWithEmptyStringCasesTest(){

        assertEquals(0, sentence.countingWordsOnlyLetter(""));
    }
}
