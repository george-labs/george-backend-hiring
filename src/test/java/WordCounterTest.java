import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.WordCounterService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordCounterTest {

    @Test
    public void shouldNotCountsWordWithSpecialCharacterTest() {
        String testText = "This is my first iteration test.";
        int count = WordCounterService.wordCounter(testText);
        Assertions.assertEquals(5, count);
    }

    @Test
    public void shouldNotCountWordsWithNumbersTest() {
        String testText = "This is my 1st iteration test";
        int count = WordCounterService.wordCounter(testText);
        Assertions.assertEquals(5, count);
    }

    @Test
    public void shouldSkipStopWordsTest() {
        String testText = "Mary had a little lamb";
        Set<String> stopWords = new HashSet<>();
        stopWords.add("the");
        stopWords.add("a");
        stopWords.add("on");
        stopWords.add("off");
        int count = WordCounterService.wordCounter(testText, stopWords);
        Assertions.assertEquals(4, count);
    }


}
