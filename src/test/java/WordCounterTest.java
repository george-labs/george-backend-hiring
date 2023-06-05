import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WordCounterTest {

    private final List<String> stopWords = Arrays.asList("the", "a", "on", "off");

    @Test
    public void getCountOfWords_emptyInput() {
        String emptyInput = "";

        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(emptyInput, stopWords);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void getCountOfWords_withAStopWord() {
        String emptyInput = "Mary had a little lamb";

        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(emptyInput, stopWords);

        Assertions.assertEquals(4, result);
    }

    @Test
    public void getCountOfWords_withMultipleStopWords() {
        String emptyInput = "Mary had a little lamb the on";

        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(emptyInput, stopWords);

        Assertions.assertEquals(4, result);
    }

    @Test
    public void getCountOfWords_withoutAStopWord() {
        String emptyInput = "Mary had little lamb";

        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(emptyInput, stopWords);

        Assertions.assertEquals(4, result);
    }
}
