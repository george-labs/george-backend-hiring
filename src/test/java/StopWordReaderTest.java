import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class StopWordReaderTest {

    private final String STOPWORDS_FILE = "src/test/resources/stopwords.txt";
    private final String EMPTY_STOPWORDS = "src/test/resources/stopwords_empty.txt";

    @Test
    void when_stopwords_is_empty() throws IOException {
        StopWordReader stopWordReader = new StopWordReader(EMPTY_STOPWORDS);
        int numberOfWords = stopWordReader.read();
        Assertions.assertEquals(0, numberOfWords);
    }

    @Test
    void when_ask_for_stop_word_then_return_list() throws IOException {
        StopWordReader stopWordReader = new StopWordReader(STOPWORDS_FILE);
        stopWordReader.read();
        List<String> filterList = stopWordReader.getWordsToFilterOut();
        Assertions.assertFalse(filterList.isEmpty());
    }
}