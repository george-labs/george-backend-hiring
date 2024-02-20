import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WordCounterTest {

    @Test
    public void testWordCounting() {
        String testText = "Lets try    this              " +
                "\n " +
                "\n" +
                "something";

        WordCounter wordCounter = new WordCounter();
        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 4;
    }

    @Test
    public void testWordCountingSecond() {
        String testText = "Mary had a little lamb";

        WordCounter wordCounter = new WordCounter();
        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 4;
    }

    @Test
    public void testWordCountingWithNumbers() {
        String testText = "Mary had 52 lambs at home";

        WordCounter wordCounter = new WordCounter();
        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 5;
    }

    @Test
    public void testWordCountingWithSymbols() {
        String testText = "Mary, had ** lambs at home.";

        WordCounter wordCounter = new WordCounter();
        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 5;
    }

    @Test
    public void testUniqueWords() {
        String testText = "Mary, had 55 lambs at home. lambs at home. Lambs.";

        WordCounter wordCounter = new WordCounter();
        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 9;
        assert counter.getCountUnique() == 6;
    }

    @Test
    public void testWithHyphen() {
        String testText = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

        WordCounter wordCounter = new WordCounter();
        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 7;
        assert counter.getCountUnique() == 6;
    }

    @Test
    public void testForAverage() {
        String testText = "Mary had a little lamb";

        WordCounter wordCounter = new WordCounter();
        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 4;
        assert counter.getAverageLength().equals(BigDecimal.valueOf(4.25));
    }

    @Test
    public void testForAverage2() {
        String testText = "Lets test average length";

        WordCounter wordCounter = new WordCounter();
        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 4;
        assert counter.getAverageLength().equals(BigDecimal.valueOf(5.25));
    }

}
