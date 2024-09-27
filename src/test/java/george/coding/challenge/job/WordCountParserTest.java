package george.coding.challenge.job;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCountParserTest {

    private Parser wordparser;

    /**
     * Provides arguments in following format:
     * Input text | number of words | number of unique words
     */
    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of("Mary had a little lamb", 4, 4),
                Arguments.of(" Mary had a little lamb ", 4, 4),
                Arguments.of("  Mary  had  a  little  lamb  ", 4, 4),
                Arguments.of("  Mary \t had \t  a \t little \t lamb  ", 4, 4),
                Arguments.of("  Mary \n had \n  a \n little \n lamb  ", 4, 4),
                Arguments.of(" the a on off ", 0, 0),
                Arguments.of(" The An On Off ", 4, 4),
                Arguments.of(" the1 a1 on1 off1 ", 0, 0),
                Arguments.of(" theMary aHad onLittle offLamb ", 4, 4),
                Arguments.of("", 0, 0),
                Arguments.of(" ", 0, 0),
                Arguments.of("Mary", 1, 1),
                Arguments.of("123", 0, 0),
                Arguments.of("123 456", 0, 0),
                Arguments.of("123 Mary 456", 1, 1),
                Arguments.of("123Mary456", 1, 1),
                Arguments.of("!@#$% ^&*()", 0, 0),
                // text fixtures for unique word count
                Arguments.of("Mary Mary Mary", 3, 1),
                Arguments.of("Mary mary MARY", 3, 3),
                Arguments.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall", 9, 7)
        );
    }

    @BeforeEach
    void setUp() throws IOException {
        wordparser = new WordCountParser();
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void checksWordParserCountResult(String input, int expectedCount, int expectedUniqueCount) {
        // given
        // when
        var result = wordparser.parse(input);

        // then
        assertEquals(expectedCount, result.wordCount());
        assertEquals(expectedUniqueCount, result.uniqueWordCount());
    }

}