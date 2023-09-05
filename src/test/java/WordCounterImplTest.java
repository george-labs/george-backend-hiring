import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterImplTest {

    private WordCounter wordCounter;

    static Set<String> STOP_WORDS = Set.of("word1", "word2");

    @BeforeEach
    void setup() {
        wordCounter = new WordCounterImpl();
    }

    @ParameterizedTest
    @MethodSource("wordCountsParameters")
    void should_count_words(String inputSentence, int expectedWordCount) {
        // call the actual count words method
        final long actualWordCounts = wordCounter.countWords(inputSentence, STOP_WORDS);

        // assert the expected result
        assertEquals(expectedWordCount, actualWordCounts);
    }

    private static Stream<Arguments> wordCountsParameters() {
        return Stream.of(
                Arguments.of("word word1 word", 2),
                Arguments.of("word word word1 word2 word", 3),
                Arguments.of("  word          word2                     ", 1),
                Arguments.of("wo3rd word1", 0),
                Arguments.of(" word   word1  word?     wo22rd word", 2),
                Arguments.of("", 0),
                Arguments.of(null, 0)
        );
    }
}
