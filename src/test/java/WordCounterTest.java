import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

public class WordCounterTest {

    private WordCounter wordCounter;

    @BeforeEach
    public void prepareDependencies() {
        Set<String> stopWords = ReadFileAdapter.getStopWords();
        this.wordCounter = new WordCounter(stopWords);
    }

    @Test
    public void testWordCounting() {
        String testText = "Lets try    this              " +
                "\n " +
                "\n" +
                "something";

        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 4;
    }

    @Test
    public void testWordCountingSecond() {
        String testText = "Mary had a little lamb";

        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 4;
    }

    @Test
    public void testWordCountingWithNumbers() {
        String testText = "Mary had 52 lambs at home";

        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 5;
    }

    @Test
    public void testWordCountingWithSymbols() {
        String testText = "Mary, had ** lambs at home.";

        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 5;
    }

    @Test
    public void testUniqueWords() {
        String testText = "Mary, had 55 lambs at home. lambs at home. Lambs.";

        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 9;
        assert counter.getCountUnique() == 6;
    }

    @Test
    public void testWithHyphen() {
        String testText = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 7;
        assert counter.getCountUnique() == 6;
    }

    @Test
    public void testForAverage() {
        String testText = "Mary had a little lamb";

        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 4;
        assert counter.getAverageLength().equals(BigDecimal.valueOf(4.25));
    }

    @Test
    public void testForAverage2() {
        String testText = "Lets test average length";

        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 4;
        assert counter.getAverageLength().equals(BigDecimal.valueOf(5.25));
    }

    @Test
    public void testForIndex() {
        String testText = "Lets test average length test test average";

        Counter counter = wordCounter.countWords(testText);
        assert counter.getCount() == 7;
        assert counter.getAverageLength().equals(BigDecimal.valueOf(5.15));
        assert counter.getUsedWords().contains("Lets");
        assert counter.getUsedWords().contains("test");
        assert counter.getUsedWords().contains("average");
        assert counter.getUsedWords().contains("length");
        assert counter.getUsedWords().size() == 4;
    }

}
