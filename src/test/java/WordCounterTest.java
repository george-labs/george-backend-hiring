import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {

    WordCounter wc = new WordCounter();

    @Test
    public void testEmptyString() {
        Assertions.assertEquals( 0, wc.countWords(""));
    }

    @Test
    public void testNullString() {
        Assertions.assertEquals( 0, wc.countWords(null));
    }

    @Test
    public void test4Words() {
        Assertions.assertEquals( 4, wc.countWords("Abs asd pijfd sjdf"));
    }

    @Test
    public void test1Word() {
        Assertions.assertEquals( 1, wc.countWords("Abs"));
    }

    @Test
    public void test1WordWith2StartingSpace() {
        Assertions.assertEquals( 1, wc.countWords("  Abs"));
    }

    @Test
    public void test1WordWithEndingSpace() {
        Assertions.assertEquals( 1, wc.countWords("Abs "));
    }

    @Test
    public void test2WordWithStartingAndEndingSpaces() {
        Assertions.assertEquals( 1, wc.countWords(" Abs  "));
    }

    @Test
    public void test2WordWithStartingAndEndingSpaceAndTabBetween() {
        Assertions.assertEquals( 2, wc.countWords(" Abs    asdasd "));
    }

    @Test
    public void testWordsWithSpecialCharacters() {
        Assertions.assertEquals( 1, wc.countWords(" A3bs akds#sj ad! asd"));
    }

    @Test
    public void testNewLineCharacter() {
        Assertions.assertEquals( 2, wc.countWords(" asd \n asd "));
    }

    @Test
    public void test2ExcludedWords() {
        Assertions.assertEquals( 4, wc.countWords(" asd \n asd on asd off asd"));
    }

    @Test
    public void testAllExcludedWords() {
        Assertions.assertEquals( 0, wc.countWords("on off a the"));
    }

}