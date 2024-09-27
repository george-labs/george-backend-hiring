package george.coding.challenge.job;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCountParserTest {

    private Parser wordparser;

    @BeforeEach
    void setUp() throws IOException {
        wordparser = new WordCountParser();
    }

    @ParameterizedTest
    @CsvSource({
            "'Mary had a little lamb', 4",
            "' Mary had a little lamb ', 4",
            "'  Mary  had  a  little  lamb  ', 4",
            "'  Mary \t had \t  a \t little \t lamb  ', 4",
            "'  Mary \n had \n  a \n little \n lamb  ', 4",
            "' the a on off ', 0",
            "' The An On Off ', 4",
            "' the1 a1 on1 off1 ', 0",
            "' theMary aHad onLittle offLamb ', 4",
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