import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

class WordCounterTest {

    private static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of("asd", List.of(), new WordCount(1, 1, 3.0, Set.of())),
                Arguments.of("asd asd", List.of(), new WordCount(2, 0, 3.0, Set.of())),
                Arguments.of(null, List.of(), new WordCount(0, 0, 0.0, Set.of())),
                Arguments.of("Mary had a little lamb", List.of(), new WordCount(5, 5, 3.6, Set.of())),
                Arguments.of("asd      asd", List.of(), new WordCount(2, 0, 3.0, Set.of())),
                Arguments.of("asd a@", List.of(), new WordCount(1, 1, 3.0, Set.of())),
                Arguments.of("Mary had a little lamb", List.of("the", "a", "on", "off"),
                        new WordCount(4, 4, 4.25, Set.of())),
                Arguments.of("the a on off", List.of("the", "a", "on", "off"), new WordCount(0, 0, 0, Set.of())),
                Arguments.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.",
                        List.of("the", "a", "on", "off"), new WordCount(7, 5, 6.43, Set.of())));
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void tesWordCount(String input, List<String> ignoredWords, WordCount expectedOutput) {
        var wordCounter = new WordCounter(ignoredWords, new TestParamParserNoIndex(), () -> input);
        Assertions.assertEquals(expectedOutput, wordCounter.countWords());
    }

    @Test
    void testWordCountFromFile() {
        var wordCounter = new WordCounter(List.of(), new TestParamParserNoIndex(), () -> "mytext.txt");
        var wordCount = wordCounter.countWords();
        Assertions.assertEquals(new WordCount(5, 5, 3.6, Set.of()), wordCount);
    }

    @Test
    void testWordCountWithIndex() {
        var wordCounter = new WordCounter(List.of("a"), new TestParamParserWithIndex(), () -> "Mary had a little lamb");
        var wordCount = wordCounter.countWords();
        Assertions.assertEquals(Set.of("Mary", "had", "little", "lamb"), wordCount.getCountedWords());
    }

    private class TestParamParserNoIndex implements ParamParser {

        @Override
        public boolean shouldCreateIndex() {
            return false;
        }

        @Override
        public Optional<String> getFileName() {
            return Optional.of("mytext.txt");
        }

        @Override
        public Optional<String> getDictionaryFileName() {
            return Optional.empty();
        }
    }

    private class TestParamParserWithIndex implements ParamParser {

        @Override
        public boolean shouldCreateIndex() {
            return true;
        }

        @Override
        public Optional<String> getFileName() {
            return Optional.of("mytext.txt");
        }

        @Override
        public Optional<String> getDictionaryFileName() {
            return Optional.empty();
        }
    }
}