import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JavaApplicationTest {

    //TODO: Parameterized
    @Test
    public void testCountWordsMethod(){
        String acceptedChars = "^[a-zA-Z]*";
        List<String> input = Arrays.asList("merry lamb the","2 2 3 4", "  d on a 34= *ff", "  ");
        int[] expectedOutput = {2, 0, 1,0};

        for (String in: input) {
            int wordsCnt = JavaApplication.countWords(in, acceptedChars);
            Assertions.assertEquals(wordsCnt , expectedOutput[input.indexOf(in)]);
        }
    }

    @Test
    public void testGetStopWordsFromFileMethod_failure(){
        String invalidPath = "invalid.path";
        Assertions.assertThrows(RuntimeException.class, () -> JavaApplication.getStopWordsFromFile(invalidPath));
    }

    @Test
    public void testGetStopWordsFromFileMethod_success(){
        List<String> stopWords = JavaApplication.getStopWordsFromFile(JavaApplication.STOP_WORD_FILE_PATH);
        List<String> expectedStopWords = Arrays.asList("the", "a","on","off");
        Assertions.assertArrayEquals(stopWords.toArray(),expectedStopWords.toArray());
    }
}
