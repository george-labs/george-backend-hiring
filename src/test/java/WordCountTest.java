import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTest {


    private final WordCount wordCount;

    public WordCountTest() {

        this.wordCount = new WordCountService(new FileReader());
    }

    @Test
    void countWordsWithSpecialCharactersReturnsExpectedly() {

        int expectedResult = 2;
        List<String> words = TextHelper.splitAndTrimText("Mary had !@#@$");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithJustNumbersReturnsZero() {

        int expectedResult = 0;
        List<String> words = TextHelper.splitAndTrimText("11 22");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithEmptyStringReturnsZero() {

        int expectedResult = 0;
        List<String> words = TextHelper.splitAndTrimText("");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }


    @Test
    void countWordsWithNullInputReturnsZero() {

        int expectedResult = 0;
        List<String> words = TextHelper.splitAndTrimText(null);
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }


    @Test
    void countWordsWithMultipleSpacesReturnsExpectedWords() {

        int expectedResult = 4;
        List<String> words = TextHelper.splitAndTrimText("   Mary       had a little lamb  ");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithStopWordIgnoresStopWord() {

        int expectedResult = 4;
        List<String> words = TextHelper.splitAndTrimText("Mary had a little lamb");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }


    @Test
    void countWordsWithOnlyStopWordsReturnsZero() {

        int expectedResult = 0;
        List<String> words = TextHelper.splitAndTrimText("the a on off");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithUpperCaseStopWordReturnsExpectedly() {

        List<String> words = TextHelper.splitAndTrimText("Mary had A little lamb");
        int result = wordCount.countWords(words);

        int expectedResult = 4;
        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithNumbersIncludedCountsOnlyWords() {

        int expectedResult = 6;
        List<String> words = TextHelper.splitAndTrimText("Mary had a little lamb and 1 cow");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }
}
