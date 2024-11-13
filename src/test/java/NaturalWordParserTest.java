import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NaturalWordParserTest {

    private final WordParser parser = new NaturalWordParser();

    @ParameterizedTest
    @CsvSource({
            "2,1,2, ad ad",
            "1,1,5, adads",
            "0,0,0 ,''",
            "3, 2, 4.333333333, this other this",
            "2, 2, 4.5, th-is ot.her this"
    })
    void shouldParseWithSuccess(int expectedCount, int uniqueCount, double averageLength, String input) {
        Assertions.assertEquals(expectedCount, parser.countWords(input).wordCount);
        Assertions.assertEquals(uniqueCount, parser.countWords(input).uniqueWordCount);
        Assertions.assertEquals(averageLength, parser.countWords(input).avergeWordLength, 0.00001);
    }

    @Test
    void shouldHandleNull() {
        Assertions.assertThrows(IllegalStateException.class, () -> parser.countWords(null));
    }


}