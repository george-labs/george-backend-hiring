package wordcounter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private final StopWordsService stopWordsService = new StopWordsService("stopwords.txt", new FileReader());
    private final WordCounter wordCounter = new WordCounter(stopWordsService);

    private static Stream<Arguments> provideTextAndExpectedWordCount() {
        return Stream.of(
                Arguments.of("Mary had a little lamb", 5),
                Arguments.of("Mary had a stopWord lamb", 4),
                Arguments.of("Mary! had. a? little, lamb.", 5),
                Arguments.of("Mary&^had a lit'tle la1mb", 1),
                Arguments.of(" ", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTextAndExpectedWordCount")
    public void countWords_countValidWords(String text, long expected) {
        long wordsCount = wordCounter.countWords(text);
        assertEquals(expected, wordsCount);
    }

}
