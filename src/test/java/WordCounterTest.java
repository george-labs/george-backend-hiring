import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class WordCounterTest {

    private WordCounter wordCounter = new WordCounter();

    private static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of("asd", List.of(), 1),
                Arguments.of("asd asd", List.of(), 2),
                Arguments.of(null, List.of(), 0),
                Arguments.of("Mary had a little lamb", List.of(), 5),
                Arguments.of("asd      asd", List.of(), 2),
                Arguments.of("asd a@", List.of(), 1),
                Arguments.of("Mary had a little lamb", List.of("the", "a", "on", "off"), 4),
                Arguments.of("the a on off", List.of("the", "a", "on", "off"), 0));
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void tesWordCount(String input, List<String> ignoredWords, int expectedOutput) {
        Assertions.assertEquals(expectedOutput, wordCounter.countWords(input, ignoredWords));
    }
}