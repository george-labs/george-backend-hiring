import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.StopWordService;
import service.StopWordServiceImpl;

import java.util.List;

public class StopWordServiceTest {

    StopWordService stopWordService = new StopWordServiceImpl("src/test/resources/test_stop_words.txt");

    @Test
    public void testStopWordService() {
        List<String> stopWords = stopWordService.getIgnoredWords();

        Assertions.assertEquals(4, stopWords.size());
    }
}
