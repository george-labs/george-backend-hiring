import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class WordCounterTest {

    private static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of("asd", List.of(), new WordCount(1, 1, 3.0)),
                Arguments.of("asd asd", List.of(), new WordCount(2, 0,3.0)),
                Arguments.of(null, List.of(), new WordCount(0, 0,0.0)),
                Arguments.of("Mary had a little lamb", List.of(), new WordCount(5, 5,3.6)),
                Arguments.of("asd      asd", List.of(), new WordCount(2, 0,3.0)),
                Arguments.of("asd a@", List.of(), new WordCount(1, 1,3.0)),
                Arguments.of("Mary had a little lamb", List.of("the", "a", "on", "off"), new WordCount(4, 4,4.25)),
                Arguments.of("the a on off", List.of("the", "a", "on", "off"), new WordCount(0, 0,0)),
                Arguments.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", List.of("the", "a", "on", "off"), new WordCount(7, 5,6.43)));
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void tesWordCount(String input, List<String> ignoredWords, WordCount expectedOutput) {
        var wordCounter = new WordCounter(ignoredWords);
        Assertions.assertEquals(expectedOutput, wordCounter.countWords(input));
    }

    @Test
    void testWordCountFromFile() {
        var wordCounter = new WordCounter(List.of());
        var wordCount = wordCounter.countWordsFromFile("mytext.txt");
        Assertions.assertEquals(new WordCount(5, 5,3.6), wordCount);
    }
}