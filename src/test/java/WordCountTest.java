import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTest {


    private final WordCount wordCount;

    public WordCountTest() {

        this.wordCount = new WordCount(new FileReader());
    }

    @Test
    void test() {

        int expectedResult = 5;
        int result = WordCount.countWords("Mary had a little lamb");

        assertEquals(expectedResult, result);
    }

    @Test
    void testWithSigns() {

        int expectedResult = 2;
        int result = WordCount.countWords("Mary had !@#@$");

        assertEquals(expectedResult, result);
    }

    @Test
    void testWithoutAnyWord() {

        int expectedResult = 0;
        int result = WordCount.countWords("11 22");

        assertEquals(expectedResult, result);
    }

    @Test
    void testWithEmptyString() {

        int expectedResult = 0;
        int result = WordCount.countWords("");

        assertEquals(expectedResult, result);
    }


    @Test
    void testWithNullInput() {

        int expectedResult = 0;
        int result = WordCount.countWords(null);

        assertEquals(expectedResult, result);
    }


    @Test
    void testWithMultipleParts() {

        int expectedResult = 5;
        int result = WordCount.countWords("   Mary       had a little lamb  ");

        assertEquals(expectedResult, result);
    }

    @Test
    void testCountWordsExcludingStopWords() throws Exception {

        int expectedResult = 4;
        int result = wordCount.countWordsExcludingStopWords("Mary had a little lamb");

        assertEquals(expectedResult, result);
    }


    @Test
    void testCountWordsExcludingStopWordsAllStopWords() throws Exception {

        int expectedResult = 0;
        int result = wordCount.countWordsExcludingStopWords("the a on off");

        assertEquals(expectedResult, result);
    }

    @Test
    void testCountWordsExcludingStopWordsUpperCase() throws Exception {

        int expectedResult = 4;
        int result = wordCount.countWordsExcludingStopWords("Mary had A little lamb");

        assertEquals(expectedResult, result);
    }

    @Test
    void testCountWordsExcludingStopWordsNumbers() throws Exception {

        int expectedResult = 6;
        int result = wordCount.countWordsExcludingStopWords("Mary had a little lamb and 1 cow");

        assertEquals(expectedResult, result);
    }
}
