import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WordCounterTest {

    WordCounter wc;

    @BeforeAll
    public void initWordCounter() {
        wc = new WordCounter(null);
    }

    @Test
    public void testEmptyString() {
        Assertions.assertEquals(0, wc.countWords("").getWordCount());
    }

    @Test
    public void testNullString() {
        Assertions.assertEquals(0, wc.countWords(null).getWordCount());
    }

    @Test
    public void test4Words() {
        Assertions.assertEquals(4, wc.countWords("Abs asd pijfd sjdf").getWordCount());
    }

    @Test
    public void test1Word() {
        Assertions.assertEquals(1, wc.countWords("Abs").getWordCount());
    }

    @Test
    public void test1WordWith2StartingSpace() {
        Assertions.assertEquals(1, wc.countWords("  Abs").getWordCount());
    }

    @Test
    public void test1WordWithEndingSpace() {
        Assertions.assertEquals(1, wc.countWords("Abs ").getWordCount());
    }

    @Test
    public void test2WordWithStartingAndEndingSpaces() {
        Assertions.assertEquals(1, wc.countWords(" Abs  ").getWordCount());
    }

    @Test
    public void test2WordWithStartingAndEndingSpaceAndTabBetween() {
        Assertions.assertEquals(2, wc.countWords(" Abs    asdasd ").getWordCount());
    }

    @Test
    public void testWordsWithSpecialCharacters() {
        Assertions.assertEquals(1, wc.countWords(" A3bs akds#sj ad! asd").getWordCount());
    }

    @Test
    public void testNewLineCharacter() {
        CountResult results =  wc.countWords(" asd \n asd ");
        Assertions.assertEquals(2,results.getWordCount());
        Assertions.assertEquals(1,results.getDistinctCount());

    }

    @Test
    public void test2DefaultExcludedWords() {
        CountResult results = wc.countWords(" asd \n asd on asd off asd");
        Assertions.assertEquals(4, results.getWordCount());
        Assertions.assertEquals(1, results.getDistinctCount());
    }

    @Test
    public void testAllDefaultExcludedWords() {
        Assertions.assertEquals(0, wc.countWords("on off a the").getWordCount());
    }

    @Test
    public void testNewLineInsideWord() {
        Assertions.assertEquals(2, wc.countWords("asd\nnasd").getWordCount());
    }
}