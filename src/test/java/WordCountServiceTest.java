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

    @Test
    void test_countWordsInStringWithStopwords_validStringAndStopwords(){
        //Given
        String input = "Mary had a little lamb";
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "a", "on", "off"));
        int expected = 4;

        //Then
        Assertions.assertEquals(expected, WordCountService.countWordsInStringWithStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_validStringAndStopwordsCaseSensitivity(){
        //Given
        String input = "Mary had a little lamb";
        Set<String> stopWords = new HashSet<>(Arrays.asList("mary", "HAD", "a", "little", "Lamb"));
        int expected = 3;

        //Then
        Assertions.assertEquals(expected, WordCountService.countWordsInStringWithStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_validStringNoStopwords(){
        //Given
        String input = "Mary had a little lamb";
        Set<String> stopWords = new HashSet<>();
        int expected = 5;

        //Then
        Assertions.assertEquals(expected, WordCountService.countWordsInStringWithStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_validStringNoMatchingStopwords(){
        //Given
        String input = "Mary had a little lamb";
        Set<String> stopWords = new HashSet<>(Arrays.asList("Cool", "Day", "Today"));
        int expected = 5;

        //Then
        Assertions.assertEquals(expected, WordCountService.countWordsInStringWithStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_emptyStringValidStopwords(){
        //Given
        String input = "          ";
        Set<String> stopWords = new HashSet<>(Arrays.asList("Cool", "Day", "Today"));
        int expected = 0;

        //Then
        Assertions.assertEquals(expected, WordCountService.countWordsInStringWithStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_emptyStringNoStopwords(){
        //Given
        String input = "          ";
        Set<String> stopWords = new HashSet<>();
        int expected = 0;

        //Then
        Assertions.assertEquals(expected, WordCountService.countWordsInStringWithStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_validStringStopwordsNull(){
        //Given
        String input = "Mary had a little lamb";
        Set<String> stopWords = null;

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                WordCountService.countWordsInStringWithStopwords(input, stopWords));
        }
}
