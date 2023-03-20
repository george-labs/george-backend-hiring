import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {

    @Test
    public void testEmptyString() {
        Assertions.assertEquals( 0, WordCounter.countWords(""));
    }

    @Test
    public void testNullString() {
        Assertions.assertEquals( 0, WordCounter.countWords(null));
    }

    @Test
    public void test4Words() {
        Assertions.assertEquals( 4, WordCounter.countWords("Abs asd pijfd sjdf"));
    }

    @Test
    public void test1Word() {
        Assertions.assertEquals( 1, WordCounter.countWords("Abs"));
    }

    @Test
    public void test1WordWith2StartingSpace() {
        Assertions.assertEquals( 1, WordCounter.countWords("  Abs"));
    }

    @Test
    public void test1WordWithEndingSpace() {
        Assertions.assertEquals( 1, WordCounter.countWords("Abs "));
    }

    @Test
    public void test2WordWithStartingAndEndingSpaces() {
        Assertions.assertEquals( 1, WordCounter.countWords(" Abs  "));
    }

    @Test
    public void test2WordWithStartingAndEndingSpaceAndTabBetween() {
        Assertions.assertEquals( 2, WordCounter.countWords(" Abs    asdasd "));
    }

    @Test
    public void testWordsWithSpecialCharacters() {
        Assertions.assertEquals( 1, WordCounter.countWords(" A3bs akds#sj ad! asd"));
    }

    @Test
    public void testNewLineCharacter() {
        Assertions.assertEquals( 2, WordCounter.countWords(" asd \n asd "));
    }
}