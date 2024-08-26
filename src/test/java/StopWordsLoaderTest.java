import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class StopWordsLoaderTest {

    @Test
    public void test_load_stop_words_success() throws IOException {
        var stopWords = StopWordsLoader.loadStopWords();

        Assertions.assertNotNull(stopWords);
    }

    @Test
    public void test_load_stop_words_file_not_found() {
        Assertions.assertThrows(IOException.class, () -> {
            StopWordsLoader.loadStopWords("nonexistent.txt");
        });
    }

}
