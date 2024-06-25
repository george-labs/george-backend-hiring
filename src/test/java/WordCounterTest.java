import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WordCounterTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void testWordCount(String input, int expectedCount) {
        var result = new WordCounter().countWords(input);
        Assertions.assertEquals(expectedCount, result);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("Mary had a little lamb", 5),
                Arguments.of("Mary had a little lamb 7", 5),
                Arguments.of("Mary had a little   lamb ", 5),
                Arguments.of("Mary had a little li312tt321le   lamb ", 5),
                Arguments.of("Mary had a little   lamb !ddsf .dsasd", 5),
                Arguments.of("4234232 423423", 0),
                Arguments.of("4234232 .....", 0),
                Arguments.of("4234232 ..... asdhksadhjagsdhaghasdj k", 2)
        );
    }

    @Test
    void testEmptyString() {
        var result = new WordCounter().countWords("");
        Assertions.assertEquals(0, result);
    }
}