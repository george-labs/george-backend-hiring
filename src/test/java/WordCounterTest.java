import org.junit.jupiter.api.Test;

public class WordCounterTest {

    @Test
    public void testWordCounting() {
        String testText = "Lets try    this              " +
                "\n " +
                "\n" +
                "something";

        WordCounter wordCounter = new WordCounter();
        long words = wordCounter.countWords(testText);
        assert words == 4;
    }

    @Test
    public void testWordCountingSecond() {
        String testText = "Mary had a little lamb";

        WordCounter wordCounter = new WordCounter();
        long words = wordCounter.countWords(testText);
        assert words == 5;
    }

    @Test
    public void testWordCountingWithNumbers() {
        String testText = "Mary had 52 lambs at home";

        WordCounter wordCounter = new WordCounter();
        long words = wordCounter.countWords(testText);
        assert words == 5;
    }

    @Test
    public void testWordCountingWithSymbols() {
        String testText = "Mary, had ** lambs at home.";

        WordCounter wordCounter = new WordCounter();
        long words = wordCounter.countWords(testText);
        assert words == 5;
    }

}
