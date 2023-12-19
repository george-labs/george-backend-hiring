import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WordCounterTest {

    private WordCounter wordCounter = new WordCounter();

    private static Stream<Arguments> testSource() {
        return Stream.of(Arguments.of("asd", 1),
                Arguments.of("asd asd", 2),
                Arguments.of(null, 0),
                Arguments.of("Mary had a little lamb", 5),
                Arguments.of("asd      asd", 2),
                Arguments.of("asd a@", 1));
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void tesWordCount(String input, int expectedOutput) {
        Assertions.assertEquals(expectedOutput, wordCounter.countWords(input));
    }
}