import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StopWordsTest {

    private StopWords testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new StopWords("test-stopwords.txt");
    }

    @Test
    void testInit_givenFileName_thenAllDefinedWordsArePresentInSetOfStopWords() {
        assertEquals(4, testSubject.getAllStopWords().size());
        assertTrue(testSubject.getAllStopWords().contains("the"));
        assertTrue(testSubject.getAllStopWords().contains("a"));
        assertTrue(testSubject.getAllStopWords().contains("on"));
        assertTrue(testSubject.getAllStopWords().contains("off"));
    }

    @Test
    void testIsStopWord_givenStopWord_thenReturnTrue() {
        assertTrue(testSubject.isStopWord("the"));
        assertTrue(testSubject.isStopWord("The"));
        assertTrue(testSubject.isStopWord("THE"));
        assertTrue(testSubject.isStopWord("a"));
        assertTrue(testSubject.isStopWord("on"));
        assertTrue(testSubject.isStopWord("off"));
    }

    @Test
    void testIsStopWord_givenNotStopWord_thenReturnFalse() {
        assertFalse(testSubject.isStopWord(null));
        assertFalse(testSubject.isStopWord(""));
        assertFalse(testSubject.isStopWord("    "));
        assertFalse(testSubject.isStopWord("something"));
        assertFalse(testSubject.isStopWord("123"));
        assertFalse(testSubject.isStopWord("???"));
    }
}