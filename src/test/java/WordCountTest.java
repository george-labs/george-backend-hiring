import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTest {

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
}
