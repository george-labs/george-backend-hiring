import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCountServiceTest {
    //Just for show
    /*@ParameterizedTest
    @CsvSource({
            "Hello World,2",
            "hello word,2",
            "HELLO WORD,2",
            "Hellö Wörld saß,0",
            "hello word,2",
    })
    void test_countWordsInStringShouldCount(String input, int expected) {
        final var result = WordCountService.countWordsInString(input);

        Assertions.assertEquals(expected, result);
    }*/

    private WordCountService wordCountService = new WordCountService();

    @Test
    void test_countWordsInStringWithStopwords_validStringAndStopwords(){
        //Given
        List<String> input = List.of("Mary", "had", "a", "little", "lamb");
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "a", "on", "off"));
        int expected = 4;

        //Then
        Assertions.assertEquals(expected, wordCountService.countWordsInStringWithStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_validStringAndStopwordsCaseSensitivity(){
        //Given
        List<String> input = List.of("Mary", "had", "a", "little", "lamb");
        Set<String> stopWords = new HashSet<>(Arrays.asList("mary", "HAD", "a", "little", "Lamb"));
        int expected = 3;

        //Then
        Assertions.assertEquals(expected, wordCountService.countWordsInStringWithStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_validStringNoStopwords(){
        //Given
        List<String> input = List.of("Mary", "had", "a", "little", "lamb");
        Set<String> stopWords = new HashSet<>();
        int expected = 5;

        //Then
        Assertions.assertEquals(expected, wordCountService.countWordsInStringWithStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_validStringNoMatchingStopwords(){
        //Given
        List<String> input = List.of("Mary", "had", "a", "little", "lamb");
        Set<String> stopWords = new HashSet<>(Arrays.asList("Cool", "Day", "Today"));
        int expected = 5;

        //Then
        Assertions.assertEquals(expected, wordCountService.countWordsInStringWithStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_validStringStopwordsNull(){
        //Given
        List<String> input = List.of("Mary", "had", "a", "little", "lamb");
        Set<String> stopWords = null;

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                wordCountService.countWordsInStringWithStopwords(input, stopWords));
    }
}
