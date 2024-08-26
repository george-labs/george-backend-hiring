import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ResourceUtils;

import java.io.IOException;
import java.util.List;

public class FileLoaderTest {

    @Test
    public void test_load_stop_words_success() throws IOException {
        ResourceUtils.populateStopWords(List.of("cat", "dog"));

        var stopWords = FileLoader.loadStopWords();

        Assertions.assertNotNull(stopWords);
        Assertions.assertEquals(2, stopWords.size());
    }

    @Test
    public void test_file_not_found() {
        Assertions.assertThrows(IOException.class, () -> {
            FileLoader.loadStopWords("nonexistent.txt");
        });

        Assertions.assertThrows(IOException.class, () -> {
            FileLoader.loadInputContent("nonexistent.txt");
        });
    }

}
