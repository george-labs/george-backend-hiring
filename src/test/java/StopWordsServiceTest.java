import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class StopWordsServiceTest {

    @Test
    void when_the_file_with_stop_words_doesnt_exist_then_throw_exception() {

        StopWordsService stopWordsService = new StopWordsService();

        Assertions.assertThrows(RuntimeException.class,
                () -> stopWordsService.getStopWords(Path.of("src/test/resources/stopwords-test-not-exists.txt")));

    }

    @Test
    void when_the_file_with_stop_words_exist_then_read_stop_words_from_file() {

        StopWordsService stopWordsService = new StopWordsService();
        var stopWords = stopWordsService.getStopWords(Path.of("src/test/resources/stopwords-test.txt"));

        Assertions.assertNotNull(stopWords);
        Assertions.assertEquals(4, stopWords.size());
    }
}