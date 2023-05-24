import kotlin.text.Regex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class WordCounterTest {

    @Test
    void countWordsInLine() {
        final List<String> stopWords = new ArrayList<>();
        stopWords.add("the");
        stopWords.add("an");
        final WordCounter wordCounter = new WordCounter(new Regex("[A-Za-z]+"), stopWords);
        String example = "word6 the  text";
        Integer expected = 1;
        Integer actual = wordCounter.countWordsInLine(example);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countWordsInLineWithNoStopWords() {
        final List<String> stopWords = new ArrayList<>();
        final WordCounter wordCounter = new WordCounter(new Regex("[A-Za-z]+"), stopWords);
        String example = "word6 the  text";
        Integer expected = 1;
        Integer actual = wordCounter.countWordsInLine(example);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countWordsInLineException() {
        final WordCounter wordCounter = new WordCounter(null, Collections.emptyList());
        String example = "word6 th(s  text";
        Assertions.assertThrows(NullPointerException.class, () -> wordCounter.countWordsInLine(example));
    }

    @Test
    void countWordsInLineWrongFilter() {
        final WordCounter wordCounter = new WordCounter(new Regex("[0-9]+"), Collections.emptyList());
        String example = "word6 th(s  text";
        Integer expected = 1;
        Integer actual = wordCounter.countWordsInLine(example);
        Assertions.assertNotEquals(expected, actual);
    }
}