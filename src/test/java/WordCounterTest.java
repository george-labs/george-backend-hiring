import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class WordCounterTest {

    public void testWordCounter() {

        /**
         * "word" -> 1
         * "word word" -> 2
         * "         word word         word" -> 3
         * "wo33d" -> 0
         * "      word          wo33rd" -> 1
         * "     word,        word.    word!      word " -> 1
         */

    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of("word", 1),
                Arguments.of("word word", 2),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }
}
