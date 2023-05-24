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
        final Counter wordCounter = new WordCounter(new Regex("[A-Za-z]+"), stopWords, example);
        Integer expected = 1;

        //When
        Integer actual = wordCounter.count();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countWordsInLineWithNoStopWords() {
        final List<String> stopWords = new ArrayList<>();
        String example = "word6 the  text";
        final Counter wordCounter = new WordCounter(new Regex("[A-Za-z]+"), stopWords, example);
        Integer expected = 2;
        Integer actual = wordCounter.count();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countWordsInLineException() {
        String example = "word6 th(s  text";
        final Counter wordCounter = new WordCounter(null, Collections.emptyList(), example);
        Assertions.assertThrows(NullPointerException.class, () -> wordCounter.count());
    }

    @Test
    void countWordsInLineWrongFilter() {
        String example = "word6 th(s  text";
        final Counter wordCounter = new WordCounter(new Regex("[0-9]+"), Collections.emptyList(), example);
        Integer expected = 1;
        Integer actual = wordCounter.count();
        Assertions.assertNotEquals(expected, actual);
    }
}