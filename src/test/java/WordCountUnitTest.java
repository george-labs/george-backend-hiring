import exception.FileIsMissingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCountUnitTest {

    private final String testOneWord = "Marry";
    private final String testSentence = "Marry had a little lamb";
    private final String testInvalidChar = "M$arry is";
    private final String testInvalidCharAllWrong = "M$arry $i #rt";

    private final String uniqueWordTest = "Humpty Dumpty sat on a wall Humpty Dumpty had a great fall";

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
        Assertions.assertEquals(1, wordCount.clearWordsList(testOneWord).size());
        Assertions.assertEquals(4, wordCount.clearWordsList(testSentence).size());
        Assertions.assertEquals(1, wordCount.clearWordsList(testInvalidChar).size());
        Assertions.assertEquals(0, wordCount.clearWordsList(testInvalidCharAllWrong).size());
        Assertions.assertEquals(9, wordCount.clearWordsList(uniqueWordTest).size());
    }

    @Test
    public void uniqueWordsTest(){
        Assertions.assertEquals(4, wordCount.countUniqueWords(wordCount.clearWordsList(testSentence)));
        Assertions.assertEquals(5, wordCount.countUniqueWords(wordCount.clearWordsList(uniqueWordTest)));
    }

    @Test
    public void wordCountInoutFileTest(){
        Assertions.assertEquals(4, wordCount.readCountWordsFromFile("E:\\Projects\\george-backend-hiring\\src\\test\\inputtext.txt"));

    }

    @Test
    public void shouldThrowFileNotFoundException(){
        Assertions.assertThrows(FileIsMissingException.class, () ->
                wordCount.readCountWordsFromFile("E:\\george-backend-hiring\\src\\test\\inputtext.txt"));
    }
}
