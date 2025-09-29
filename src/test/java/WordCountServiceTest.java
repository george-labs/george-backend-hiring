import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCountServiceTest {
    @Test
    void test_countWordsInString_normalString(){
        //Given
        String input = "Hello World";
        int expectedCount = 2;

        //Then
        Assertions.assertEquals(expectedCount, WordCountService.countWordsInString(input));
    }

    @Test
    void test_countWordsInString_allUpperCaseString(){
        //Given
        String input = "hello world";
        int expectedCount = 2;

        //Then
        Assertions.assertEquals(expectedCount, WordCountService.countWordsInString(input));
    }

    @Test
    void test_countWordsInString_allLowerCaseString(){
        //Given
        String input = "HELLO WORLD";
        int expectedCount = 2;

        //Then
        Assertions.assertEquals(expectedCount, WordCountService.countWordsInString(input));
    }

    @Test
    void test_countWordsInString_umlautString(){
        //Given
        String input = "Hellö Wörld saß";
        int expectedCount = 0;

        //Then
        Assertions.assertEquals(expectedCount, WordCountService.countWordsInString(input));
    }

    @Test
    void test_countWordsInString_partiallyValidString(){
        //Given
        String input = "Hello World!";
        int expectedCount = 1;

        //Then
        Assertions.assertEquals(expectedCount, WordCountService.countWordsInString(input));
    }

    @Test
    void test_countWordsInString_exclamationValidString(){
        //Given
        String input = "Hello, World!";
        int expectedCount = 0;

        //Then
        Assertions.assertEquals(expectedCount, WordCountService.countWordsInString(input));
    }

    @Test
    void test_countWordsInString_noValidString(){
        //Given
        String input = "H3llo World!";
        int expectedCount = 0;

        //Then
        Assertions.assertEquals(expectedCount, WordCountService.countWordsInString(input));
    }

    @Test
    void test_countWordsInString_emptyValidString(){
        //Given
        String input = "";
        int expectedCount = 0;

        //Then
        Assertions.assertEquals(expectedCount, WordCountService.countWordsInString(input));
    }

    @Test
    void test_countWordsInString_spaceValidString(){
        //Given
        String input = "                  ";
        int expectedCount = 0;

        //Then
        Assertions.assertEquals(expectedCount, WordCountService.countWordsInString(input));
    }

    @Test
    void test_countWordsInString_nullString(){
        //Given
        String input = null;

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> WordCountService.countWordsInString(input));
    }
}
