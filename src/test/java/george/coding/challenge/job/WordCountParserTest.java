package george.coding.challenge.job;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCountParserTest {

    private final Parser wordparser = new WordCountParser();

    @ParameterizedTest
    @CsvSource({
            "'Mary had a little lamb', 5",
            "' Mary had a little lamb ', 5",
            "'  Mary  had  a  little  lamb  ', 5",
            "'  Mary \t had \t  a \t little \t lamb  ', 5",
            "'  Mary \n had \n  a \n little \n lamb  ', 5",
            "'', 0",
            "' ', 0",
            "'Mary', 1",
            "'123', 0",
            "'123 456', 0",
            "'123 Mary 456', 1",
            "'123Mary456', 1",
            "'!@#$%^&*()', 0"
    })
    void checksWordParserCountResult(String input, int expectedCount) {
        // given
        // when
        var result = wordparser.parse(input);

        // then
        assertEquals(expectedCount, result.wordCount());
    }

}