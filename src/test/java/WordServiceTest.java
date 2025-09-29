import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordServiceTest {
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
        final var result = WordService.countWordsInString(input);

        Assertions.assertEquals(expected, result);
    }*/

    private final WordService wordService = new WordService();

    @Test
    void test_countWordsInStringWithStopwords_validStringAndStopwords(){
        //Given
        List<String> input = List.of("Mary", "had", "a", "little", "lamb");
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "a", "on", "off"));
        int expected = 4;

        //Then
        Assertions.assertEquals(expected, wordService.getWordsConsideringStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_validStringAndStopwordsCaseSensitivity(){
        //Given
        List<String> input = List.of("Mary", "had", "a", "little", "lamb");
        Set<String> stopWords = new HashSet<>(Arrays.asList("mary", "HAD", "a", "little", "Lamb"));
        int expected = 3;

        //Then
        Assertions.assertEquals(expected, wordService.getWordsConsideringStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_validStringNoStopwords(){
        //Given
        List<String> input = List.of("Mary", "had", "a", "little", "lamb");
        Set<String> stopWords = new HashSet<>();
        int expected = 5;

        //Then
        Assertions.assertEquals(expected, wordService.getWordsConsideringStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_validStringNoMatchingStopwords(){
        //Given
        List<String> input = List.of("Mary", "had", "a", "little", "lamb");
        Set<String> stopWords = new HashSet<>(Arrays.asList("Cool", "Day", "Today"));
        int expected = 5;

        //Then
        Assertions.assertEquals(expected, wordService.getWordsConsideringStopwords(input, stopWords).size());
    }

    @Test
    void test_countWordsInStringWithStopwords_validStringStopwordsNull(){
        //Given
        List<String> input = List.of("Mary", "had", "a", "little", "lamb");
        Set<String> stopWords = null;

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                wordService.getWordsConsideringStopwords(input, stopWords));
    }

    @Test
    void test_getUniqueWords_validInput(){
        //Given
        List<String> input = List.of("Humpty", "dumpty", "had", "great", "fall");
        int expected = 5;

        //Then
        Assertions.assertEquals(expected, wordService.getUniqueWords(input).size());
    }

    @Test
    void test_getUniqueWords_validInputDuplicated(){
        //Given
        List<String> input = List.of("Humpty", "Humpty", "had", "had", "fall");
        int expected = 3;

        //Then
        Assertions.assertEquals(expected, wordService.getUniqueWords(input).size());
    }

    @Test
    void test_getUniqueWords_validInputDuplicatesLowerCaseUpperCase(){
        //Given
        List<String> input = List.of("Humpty", "humpty", "had", "Had", "fall");
        int expected = 5;

        //Then
        Assertions.assertEquals(expected, wordService.getUniqueWords(input).size());
    }

    @Test
    void test_getUniqueWords_emptyInpit(){
        //Given
        List<String> input = List.of("");
        int expected = 1;

        //Then
        Assertions.assertEquals(expected, wordService.getUniqueWords(input).size());
    }

    @Test
    void test_getUniqueWords_emptyList(){
        //Given
        List<String> input = List.of();
        int expected = 0;

        //Then
        Assertions.assertEquals(expected, wordService.getUniqueWords(input).size());
    }

    @Test
    void test_getUniqueWords_invalidInput(){
        //Given
        List<String> input = null;

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> wordService.getUniqueWords(input));
    }
}
