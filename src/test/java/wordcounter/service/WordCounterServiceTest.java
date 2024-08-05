package wordcounter.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import wordcounter.FileReader;
import wordcounter.model.WordCountDto;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterServiceTest {

    private final StopWordsService stopWordsService = new StopWordsService("stopwords.txt", new FileReader());
    private final WordCounterService wordCounterService = new WordCounterService(stopWordsService);

    private static Stream<Arguments> provideTextAndExpectedWordCount() {
        return Stream.of(
                Arguments.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 10, 8, 4.9),
                Arguments.of("Mary lamb a little lamb", 5, 4, 3.8),
                Arguments.of("Mary had a stopWord lamb", 4, 4, 3.0),
                Arguments.of("Mary! had. a? little, lamb.", 5, 5, 3.6),
                Arguments.of("Mary&^had a lit'tle la1mb", 1, 1, 1),
                Arguments.of(" ", 0, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTextAndExpectedWordCount")
    public void countWords_countValidWords(String text, long expectedCount, long expectedUnique, double expectedAverageLength) {
        WordCountDto wordsCount = wordCounterService.countWords(text);
        assertEquals(expectedCount, wordsCount.getCount());
        assertEquals(expectedUnique, wordsCount.getUnique());
        assertEquals(expectedAverageLength, wordsCount.getAverageLength());
    }

}
