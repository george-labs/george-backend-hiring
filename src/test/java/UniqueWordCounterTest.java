import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.UniqueWordsCounterService;

import java.util.HashSet;
import java.util.Set;

public class UniqueWordCounterTest {
    @Test
    public void shouldSkipRepeatedWords() {
        String testText = "Humpty Dumpty sat on a wall. Humpty Dumpty had a great fall";
        Set<String> stopWords = new HashSet<>();
        stopWords.add("the");
        stopWords.add("a");
        stopWords.add("on");
        stopWords.add("off");
        int count = UniqueWordsCounterService.wordCounter(testText, stopWords);
        Assertions.assertEquals(6, count);
    }
}
