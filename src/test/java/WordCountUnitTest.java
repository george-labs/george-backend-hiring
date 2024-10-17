import exception.FileIsMissingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCountUnitTest {

    private final String testOneWord = "Marry";
    private final String testSentence = "Marry had a little lamb";
    private final String testInvalidChar = "M$arry is";
    private final String testInvalidCharAllWrong = "M$arry $i #rt";

    private final WordCount wordCount = new WordCount();

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
        Assertions.assertEquals(1, wordCount.countWords(testOneWord));
        Assertions.assertEquals(4, wordCount.countWords(testSentence));
        Assertions.assertEquals(1, wordCount.countWords(testInvalidChar));
        Assertions.assertEquals(0, wordCount.countWords(testInvalidCharAllWrong));
    }

    @Test
    public void wordCountInoutFileTest(){
        Assertions.assertEquals(4, wordCount.readCountWordsFromFile("E:\\Projects\\george-backend-hiring\\src\\test\\inputtext.txt"));

    }

    @Test
    public void shouldThrowFileNotFoundException(){
        FileIsMissingException fileIsMissingException = Assertions.assertThrows(FileIsMissingException.class, () ->
                wordCount.readCountWordsFromFile("E:\\george-backend-hiring\\src\\test\\inputtext.txt"));
    }
}
