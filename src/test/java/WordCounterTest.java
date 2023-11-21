import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class WordCounterTest {
    @ParameterizedTest
    @MethodSource("provideStringsForTest")
    void testWordCounter(String input, int expectedWordCount, int expectedUniqueWordCount) {
        WordCounter wordCounter = new WordCounter();
        Assertions.assertEquals(expectedWordCount, wordCounter.countWords(input).getWordCount());
        Assertions.assertEquals(expectedUniqueWordCount, wordCounter.countWords(input).getUniqueWordCount());
    }

    @Test
    void testWordCounterWithStopWords() {
        String input = "Mary had a little lamb";
        StopWordList stopWordList = new StopWordList(stopWords());
        WordCounter wordCounter = new WordCounter(new Tokenizer(), stopWordList);
        Assertions.assertEquals(4, wordCounter.countWords(input).getWordCount());
        Assertions.assertEquals(4, wordCounter.countWords(input).getUniqueWordCount());
    }

    private static Stream<Arguments> provideStringsForTest() {
        return Stream.of(
                Arguments.of(null, 0, 0),
                Arguments.of("Mary had a little lamb", 5, 5),
                Arguments.of("", 0, 0),
                Arguments.of("word", 1, 1),
                Arguments.of("word word", 2, 1),
                Arguments.of("         word word         word", 3, 1),
                Arguments.of("wo33d", 0, 0),
                Arguments.of("      word          wo33rd", 1, 1),
                Arguments.of("     word,        word.    word!      word ", 4, 1),
                Arguments.of("2a", 0, 0),
                Arguments.of("a2b", 0, 0), // words need to be separated by a whitespace character
                Arguments.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 10, 8) // word with hyphenation character is not split, i.e. counted as one word
        );
    }

    private static List<String> stopWords() {
        return List.of("the", "a", "on", "off");
    }
}