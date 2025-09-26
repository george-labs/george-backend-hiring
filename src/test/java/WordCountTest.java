import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTest {


    private final WordCount wordCount;

    public WordCountTest() {

        this.wordCount = new WordCountService(new FileReader());
    }

    @Test
    void countWordsWithSpecialCharactersReturnsExpectedly() {

        int expectedResult = 2;
        int result = wordCount.countWords("Mary had !@#@$");

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithJustNumbersReturnsZero() {

        int expectedResult = 0;
        int result = wordCount.countWords("11 22");

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithEmptyStringReturnsZero() {

        int expectedResult = 0;
        int result = wordCount.countWords("");

        assertEquals(expectedResult, result);
    }


    @Test
    void countWordsWithNullInputReturnsZero() {

        int expectedResult = 0;
        int result = wordCount.countWords(null);

        assertEquals(expectedResult, result);
    }


    @Test
    void countWordsWithMultipleSpacesReturnsExpectedWords() {

        int expectedResult = 4;
        int result = wordCount.countWords("   Mary       had a little lamb  ");

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithStopWordIgnoresStopWord() {

        int expectedResult = 4;
        int result = wordCount.countWords("Mary had a little lamb");

        assertEquals(expectedResult, result);
    }


    @Test
    void countWordsWithOnlyStopWordsReturnsZero() {

        int expectedResult = 0;
        int result = wordCount.countWords("the a on off");

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithUpperCaseStopWordReturnsExpectedly() {

        int expectedResult = 4;
        int result = wordCount.countWords("Mary had A little lamb");

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithNumbersIncludedCountsOnlyWords() {

        int expectedResult = 6;
        int result = wordCount.countWords("Mary had a little lamb and 1 cow");

        assertEquals(expectedResult, result);
    }
}
