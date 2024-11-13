import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SelectiveWordParserTest {

    WordParser parser = new SelectiveWordParser();


    @ParameterizedTest
    @CsvSource({
            "0,0,0, the a on off",
            "1,1,4, ahoj a on off",
            "2,2,3, the a on off vlk pes",
            "2,2,3, wee the a on off vlk"
    })
    void shouldFilterWords(int expectedCount, int uniqueCount, double averageLength, String input) {
        Assertions.assertEquals(expectedCount, parser.countWords(input).wordCount);
        Assertions.assertEquals(uniqueCount, parser.countWords(input).uniqueWordCount);
        Assertions.assertEquals(averageLength, parser.countWords(input).avergeWordLength);
    }
}