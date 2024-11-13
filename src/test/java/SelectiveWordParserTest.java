import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SelectiveWordParserTest {

    WordParser parser = new SelectiveWordParser();


    @ParameterizedTest
    @CsvSource({
            "0,0, the a on off",
            "1,1, ahoj a on off",
            "2,2, the a on off vlk pes",
            "2,2, wee the a on off vlk"

    })
    void shouldFilterWords(int expectedCount, int uniqueCount, String input) {
        Assertions.assertEquals(new AnalysisResult(expectedCount, uniqueCount), parser.countWords(input));
    }
}