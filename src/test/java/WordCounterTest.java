import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    private WordCounter testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new WordCounter();
    }

    @Test
    void testCount_givenNullText_thenThrowException() {
        try {
            testSubject.count(null);
            fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    void testCount_givenBlankText_thenThrowException() {
        try {
            testSubject.count("     ");
            fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    void testCount_givenText_thenReturnNumberOfWords() {
        assertEquals(5, testSubject.count("Mary had a little lamb"));
        assertEquals(5, testSubject.count(" Mary had a little lamb"));
        assertEquals(4, testSubject.count(" _Mary had1 a LiT tLe lamb"));
    }

    @Test
    void testCountWords_givenNullArray_thenThrowException() {
        try {
            testSubject.countWords(null);
            fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    void testCountWords_givenEmptyArray_thenReturnZero() {
        assertEquals(0, testSubject.countWords(new String[]{}));
    }

    @Test
    void testCountWords_givenArrayOfEmptyStrings_thenReturnZero() {
        assertEquals(0, testSubject.countWords(new String[]{"", "", "", ""}));
    }

    @Test
    void testCountWords_givenArray_thenReturnCountOfTheWords() {
        assertEquals(5, testSubject.countWords(new String[]{"Mary", "had", "a", "little", "lamb"}));
        assertEquals(4, testSubject.countWords(new String[]{"    ", "had", "a", "little", "lamb"}));
        assertEquals(3, testSubject.countWords(new String[]{"    ", "had1", "a", "little", "lamb"}));
        assertEquals(2, testSubject.countWords(new String[]{"    ", "had1", "a?", "little", "lamb"}));
        assertEquals(1, testSubject.countWords(new String[]{"    ", "had1", "a?", "little ", "lamb"}));
        assertEquals(0, testSubject.countWords(new String[]{"    ", "had1", "a?", "little ", " lamb"}));
    }

    @Test
    void testIsValidWord_givenNullString_thenReturnFalse() {
        assertFalse(testSubject.isValidWord(null));
    }

    @Test
    void testIsValidWord_givenEmptyString_thenReturnFalse() {
        assertFalse(testSubject.isValidWord(""));
    }

    @Test
    void testIsValidWord_givenBlankString_thenReturnFalse() {
        assertFalse(testSubject.isValidWord("     "));
    }

    @Test
    void testIsValidWord_givenNumber_thenReturnFalse() {
        assertFalse(testSubject.isValidWord("1"));
        assertFalse(testSubject.isValidWord("123"));
    }

    @Test
    void testIsValidWord_givenSpecialCharacter_thenReturnFalse() {
        assertFalse(testSubject.isValidWord("?"));
        assertFalse(testSubject.isValidWord("###"));
    }

    @Test
    void testIsValidWord_givenWordWithNumber_thenReturnFalse() {
        assertFalse(testSubject.isValidWord("someWord1"));
    }

    @Test
    void testIsValidWord_givenWordWithSpecialCharacter_thenReturnFalse() {
        assertFalse(testSubject.isValidWord("some_Word"));
    }

    @Test
    void testIsValidWord_givenValidWord_thenReturnTrue() {
        assertTrue(testSubject.isValidWord("word"));
        assertTrue(testSubject.isValidWord("ValidWord"));
    }

    @Test
    void testIsValidWord_givenValidCharacter_thenReturnTrue() {
        for (char c = 'a'; c <= 'z'; c++) {
            assertTrue(testSubject.isValidWord(String.valueOf(c)));
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            assertTrue(testSubject.isValidWord(String.valueOf(c)));
        }
    }
}