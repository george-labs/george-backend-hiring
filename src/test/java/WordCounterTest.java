import kotlin.text.Regex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class WordCounterTest {

    @Test
    void countWordsInLine() {
        //given
        final List<String> stopWords = new ArrayList<>();
        stopWords.add("the");
        stopWords.add("an");
        String example = "word6 the  text";
        final Counter wordCounter = new WordCounter(new Regex(Constraints.WORD_CONTAINING_HYPHEN_REGEX_STRING),
                stopWords,
                example,
                Constraints.DEFAULT_DELIMITER_REGEX_STRING);
        Integer expected = 1;

        //When
        Integer actual = wordCounter.count();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countWordsInLineWithNoStopWords() {
        final List<String> stopWords = new ArrayList<>();
        String example = "word6 the  text";
        final Counter wordCounter = new WordCounter(new Regex(Constraints.WORD_CONTAINING_HYPHEN_REGEX_STRING),
                stopWords,
                example,
                Constraints.DEFAULT_DELIMITER_REGEX_STRING);
        Integer expected = 2;
        Integer actual = wordCounter.count();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countWordsInLineWithHyphen() {
        final List<String> stopWords = new ArrayList<>();
        String example = "This-hyphen demo";
        final Counter wordCounter = new WordCounter(new Regex(Constraints.WORD_CONTAINING_HYPHEN_REGEX_STRING),
                stopWords,
                example,
                Constraints.DEFAULT_DELIMITER_REGEX_STRING);
        Integer expected = 2;
        Integer actual = wordCounter.count();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countWordsInLineException() {
        String example = "word6 th(s  text";
        final Counter wordCounter = new WordCounter(null,
                Collections.emptyList(),
                example,
                Constraints.DEFAULT_DELIMITER_REGEX_STRING);
        Assertions.assertThrows(NullPointerException.class, wordCounter::count);
    }

    @Test
    void countWordsInLineWrongFilter() {
        String example = "word6 th(s  text";
        final Counter wordCounter = new WordCounter(new Regex("[0-9]+"),
                Collections.emptyList(),
                example,
                Constraints.DEFAULT_DELIMITER_REGEX_STRING);
        Integer expected = 1;
        Integer actual = wordCounter.count();
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    void countUniqueWords() {
        String example = "There is a duplicate duplicate";
        final Counter wordCounter = new WordCounter(new Regex(Constraints.WORD_CONTAINING_HYPHEN_REGEX_STRING),
                Collections.emptyList(),
                example,
                Constraints.DEFAULT_DELIMITER_REGEX_STRING);
        Integer expected = 4;
        Integer actual = wordCounter.unique();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countUniqueWithNullDelimiter() {
        Assertions.assertThrows(RuntimeException.class, () ->
                new WordCounter(new Regex(Constraints.WORD_CONTAINING_HYPHEN_REGEX_STRING),
                        Collections.emptyList(),
                        "example",
                        null)
                        .count());
    }

}