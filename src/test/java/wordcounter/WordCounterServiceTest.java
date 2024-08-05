package wordcounter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import wordcounter.model.WordCountDto;
import wordcounter.service.StopWordsService;
import wordcounter.service.WordCounterService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterServiceTest {

    private final StopWordsService stopWordsService = new StopWordsService("stopwords.txt", new FileReader());
    private final WordCounterService wordCounterService = new WordCounterService(stopWordsService);

    private static Stream<Arguments> provideTextAndExpectedWordCount() {
        return Stream.of(
                Arguments.of("Mary lamb a little lamb", 5, 4),
                Arguments.of("Mary had a stopWord lamb", 4, 4),
                Arguments.of("Mary! had. a? little, lamb.", 5, 5),
                Arguments.of("Mary&^had a lit'tle la1mb", 1, 1),
                Arguments.of(" ", 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTextAndExpectedWordCount")
    public void countWords_countValidWords(String text, long expectedCount, long expectedUnique) {
        WordCountDto wordsCount = wordCounterService.countWords(text);
        assertEquals(expectedCount, wordsCount.getCount());
        assertEquals(expectedUnique, wordsCount.getUnique());
    }

}
