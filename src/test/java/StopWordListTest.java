import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StopWordListTest {
    @Test
    public void testStopWordListCreation() throws IOException {
        List<String> expectedStopWordList = List.of("the", "a", "on", "off");

        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("stopwords.txt")) {
            StopWordList list = StopWordList.of(inputStream);
            Assertions.assertEquals(expectedStopWordList, list.stopWords);
        }
    }
}
