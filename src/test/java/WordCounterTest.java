import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WordCounterTest {

    private final List<String> stopWords = Arrays.asList("the", "a", "on", "off");

    @Test
    public void getCountOfWords_emptyInput() {
        String input = "";

        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(input, stopWords);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void getCountOfWords_nullInput() {
        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(null, stopWords);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void getCountOfWords_blankInput() {
        String input = "    ";
        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(input, stopWords);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void getCountOfWords_withTab() {
        String input = "agafsg\tafgh";

        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(input, stopWords);

        Assertions.assertEquals(2, result);
    }

    @Test
    public void getCountOfWords_withLineBreak() {
        String input = "agafsg\nafgh";

        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(input, stopWords);

        Assertions.assertEquals(2, result);
    }

    @Test
    public void getCountOfWords_withAStopWord() {
        String input = "Mary had a little lamb";

        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(input, stopWords);

        Assertions.assertEquals(4, result);
    }

    @Test
    public void getCountOfWords_withMultipleStopWords() {
        String input = "Mary had a little lamb the on";

        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(input, stopWords);

        Assertions.assertEquals(4, result);
    }

    @Test
    public void getCountOfWords_withoutAStopWord() {
        String input = "Mary had little lamb";

        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(input, stopWords);

        Assertions.assertEquals(4, result);
    }

    @Test
    public void getCountOfWords_withANumber() {
        String input = "Mary had little lamb 0";

        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(input, stopWords);

        Assertions.assertEquals(4, result);
    }

    @Test
    public void getCountOfWords_withANonWord() {
        String input = "Mary had little lamb w0rd1";

        WordCounter wordCounter = new WordCounter();
        int result = wordCounter.getCountOfWords(input, stopWords);

        Assertions.assertEquals(4, result);
    }
}
