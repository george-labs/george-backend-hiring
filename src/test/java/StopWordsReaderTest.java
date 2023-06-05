import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StopWordsReaderTest {

    private final static String FILENAME_STOP_WORDS = "stopWords.txt";

    @Test
    public void getStopWordsFromResources_ () {

        StopWordsReader stopWordsReader = new StopWordsReader();
        List<String> result = stopWordsReader.getWordsFromResources(FILENAME_STOP_WORDS);

        Assertions.assertEquals(Arrays.asList("the", "a", "on", "off"), result);

    }
}
