import helper.ReadTextFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordCountInputFileUnitTest {

    private final String testOneWord = "Marry";
    private final String testSentence = "Marry had a little lamb";
    private final String testInvalidChar = "M$arry is";
    private final String testInvalidCharAllWrong = "M$arry $i #rt";

    private final WordCount wordCount = new WordCount();

    @Test
    public void wordCountInputFileTest() {

        ReadTextFile readTextFile = new ReadTextFile();

        List<String> inputWordsFromFile = readTextFile.readResourceTextFile();
        Assertions.assertNotNull(inputWordsFromFile);
        Assertions.assertEquals(6, inputWordsFromFile.size());
    }

}
