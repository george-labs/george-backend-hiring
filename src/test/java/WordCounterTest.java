import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WordCounterTest {

    @ParameterizedTest
    @MethodSource("inputs")
    void testWordCount_notDistinct(String input, int expectedCount) {
        var fileLoader = new FileLoader();
        var result = new WordCounter(fileLoader).countNotBlackListedWords(input, false);
        Assertions.assertEquals(expectedCount, result);
    }

    @ParameterizedTest
    @MethodSource("inputsDistinct")
    void testWordCount_Distinct(String input, int expectedCount) {
        var fileLoader = new FileLoader();
        var result = new WordCounter(fileLoader).countNotBlackListedWords(input, true);
        Assertions.assertEquals(expectedCount, result);
    }

    private static Stream<Arguments> inputsDistinct() {
        return Stream.of(
                Arguments.of("Mary had a a little   lamb ", 4),
                Arguments.of("Mary had a a little   lamb lamb", 4)
        );
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("Mary had a little lamb", 4),
                Arguments.of("Mary had a little lamb 7", 4),
                Arguments.of("Mary had a little   lamb ", 4),
                Arguments.of("Mary had a a little   lamb ", 4),
                Arguments.of("Mary had a a little   lamb lamb", 5),
                Arguments.of("Mary had a little li312tt321le   lamb ", 4),
                Arguments.of("Mary had a little   lamb !ddsf .dsasd", 5),
                Arguments.of("4234232 423423", 0),
                Arguments.of("4234232 .....", 1),
                Arguments.of("4234232 ..... asdhksadhjagsdhaghasdj k", 3)
        );
    }

    @Test
    void testEmptyString() {
        var result = new WordCounter(new FileLoader()).countNotBlackListedWords("", false);
        Assertions.assertEquals(0, result);
    }
}