import helper.ReadTextFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordCountInputFileUnitTest {

    @Test
    public void wordCountInputFileTest() {

        ReadTextFile readTextFile = new ReadTextFile();

        List<String> inputWordsFromFile = readTextFile.readResourceTextFile();
        Assertions.assertNotNull(inputWordsFromFile);
        Assertions.assertEquals(6, inputWordsFromFile.size());
    }

}
