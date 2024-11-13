import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NaturalWordParserTest {

    private final WordParser parser = new NaturalWordParser();

    @ParameterizedTest
    @CsvSource({
            "2,1, ad ad",
            "1,1, adads",
            "0,0 ,''",
            "3, 2, this other this",
    })
    void shouldParseWithSuccess(int expectedCount, int uniqueCount, String input) {
        Assertions.assertEquals(new AnalysisResult(expectedCount, uniqueCount), parser.countWords(input));
    }

    @Test
    void shouldHandleNull() {
        Assertions.assertThrows(IllegalStateException.class, () -> parser.countWords(null));
    }


}