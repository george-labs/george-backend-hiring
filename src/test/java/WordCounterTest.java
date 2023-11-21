import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WordCounterTest {
    @ParameterizedTest
    @MethodSource("provideStringsForTest")
    void testWordCounter(String input, int expectedResult) {
        WordCounter wordCounter = new WordCounter();
        Assertions.assertEquals(expectedResult, wordCounter.countWords(input));
    }

    private static Stream<Arguments> provideStringsForTest() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of("Mary had a little lamb", 5),
                Arguments.of("", 0),
                Arguments.of("word", 1),
                Arguments.of("word word", 2),
                Arguments.of("         word word         word", 3),
                Arguments.of("wo33d", 0),
                Arguments.of("      word          wo33rd", 1),
                Arguments.of("     word,        word.    word!      word ", 1),
                Arguments.of("2a", 0),
                Arguments.of("a2b", 0) // words need to be separated by a whitespace character
        );
    }
}