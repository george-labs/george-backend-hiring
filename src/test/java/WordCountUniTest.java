import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCountUniTest {

    private final String testOneWord = "Marry";
    private final String testSentence = "Marry had a little lamb";
    private final String testInvalidChar = "M$arry is";
    private final String testInvalidCharAllWrong = "M$arry $i #rt";

    private final WordCount wordCount = new WordCount();

    @Test
    public void wordCountTest() {

        WordCount wordCount = new WordCount();

        Assertions.assertEquals(false, wordCount.isInputCorrect(""));
    }

    @Test
    public void wordCountInputTest() {
        Assertions.assertEquals(false, wordCount.isInputCorrect(""));
        Assertions.assertEquals(false, wordCount.isInputCorrect("    "));
        Assertions.assertEquals(true, wordCount.isInputCorrect(testOneWord));
        Assertions.assertEquals(true, wordCount.isInputCorrect(testSentence));
        Assertions.assertEquals(true, wordCount.isInputCorrect(testInvalidChar));
        Assertions.assertEquals(true, wordCount.isInputCorrect(testInvalidCharAllWrong));
    }

    @Test
    public void wordCountCountResults() {
        Assertions.assertEquals(1, wordCount.countResults(testOneWord));
        Assertions.assertEquals(5, wordCount.countResults(testSentence));
        Assertions.assertEquals(1, wordCount.countResults(testInvalidChar));
        Assertions.assertEquals(0, wordCount.countResults(testInvalidCharAllWrong));
    }
}
