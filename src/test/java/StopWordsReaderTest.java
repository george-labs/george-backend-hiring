import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StopWordsReaderTest {

    @Test
    public void getStopWordsFromResources_ () {

        StopWordsReader stopWordsReader = new StopWordsReader();
        List<String> result = stopWordsReader.getStopWordsFromResources();

        Assertions.assertEquals(Arrays.asList("the", "a", "on", "off"), result);

    }
}
