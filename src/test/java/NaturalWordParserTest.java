import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NaturalWordParserTest {

    private final NaturalWordParser parser = new NaturalWordParser();

    @ParameterizedTest
    @CsvSource({
            "2, ad ad",
            "1, adads",
            "0, ''"
    })
    void positiveCase(int expectedCount, String input) {

        Assertions.assertEquals(expectedCount, parser.countWords(input));

    }
}