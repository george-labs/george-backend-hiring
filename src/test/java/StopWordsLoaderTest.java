import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ResourceUtils;

import java.io.IOException;
import java.util.List;

public class StopWordsLoaderTest {

    @Test
    public void test_load_stop_words_success() throws IOException {
        ResourceUtils.populateStopWords(List.of("cat", "dog"));

        var stopWords = StopWordsLoader.loadStopWords();

        Assertions.assertNotNull(stopWords);
        Assertions.assertEquals(2, stopWords.size());
    }

    @Test
    public void test_load_stop_words_file_not_found() {
        Assertions.assertThrows(IOException.class, () -> {
            StopWordsLoader.loadStopWords("nonexistent.txt");
        });
    }

}
