package text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordExtractorTest {
    private static final List<String> EXPECTED_SPLIT = List.of("Mary", "had", "a", "little", "lamb");


    @Test
    public void testCountNumberOfWords() {
        String input = "Mary had a little lamb";

        var extracted = new WordExtractor().getWords(input);

        Assertions.assertEquals(EXPECTED_SPLIT, extracted);
    }

    @Test
    public void testCountNumberOfWordsWithExtraNonLetterCharacters() {
        String input = "Mary had a little lamb !";

        var extracted = new WordExtractor().getWords(input);

        Assertions.assertEquals(EXPECTED_SPLIT, extracted);
    }

    @Test
    public void testCountNumberOfWordsWithPunctuation() {
        String input = "Mary had a little lamb.";

        var extracted = new WordExtractor().getWords(input);

        Assertions.assertEquals(EXPECTED_SPLIT, extracted);
    }

    @Test
    public void testCountNumberOfWordsCountHyphenAsOne() {
        String input = "Mary-had a little lamb.";

        var extracted = new WordExtractor().getWords(input);

        Assertions.assertEquals(List.of("Mary-had", "a", "little", "lamb"), extracted);
    }

    @Test
    public void testCountNumberOfWordsWithDifferentCases() {
        String input = "MAry HAD a lIttle lamb.";

        var extracted = new WordExtractor().getWords(input);

        Assertions.assertEquals(List.of("MAry", "HAD", "a", "lIttle", "lamb"), extracted);
    }

    @Test
    public void testCountNumberOfWordsEmptyInput() {
        String input = "";

        var extracted = new WordExtractor().getWords(input);


        Assertions.assertTrue(extracted.isEmpty());
    }

    @Test
    public void testCountNumberOfWordsNullInput() {
        String input = null;

        var extracted = new WordExtractor().getWords(input);

        Assertions.assertTrue(extracted.isEmpty());
    }
}
