import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WordCounterTest {

    private static Stream<Arguments> provideStringsForCountTest() {
        return Stream.of(
                Arguments.of("Mary had a little lamb", 4),
                Arguments.of("word? word. word, wo3rd  word", 1),
                Arguments.of("wo$rd       wo$$        word,    word", 1),
                Arguments.of("", 0),
                Arguments.of(null, 0),
                Arguments.of("wo3rd", 0),
                Arguments.of("the a on off", 0),
                Arguments.of("the a on had off", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForCountTest")
    public void countTest(String sentence, int expected) {
        WordCounter wordCounter = new WordCounter(new StopWords(new FileReader()));
        int count = wordCounter.count(sentence);
        Assertions.assertEquals(expected, count);
    }
}
