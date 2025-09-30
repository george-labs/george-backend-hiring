package processor;

import exception.StopWordsProviderException;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StopWordsProviderTest {

    private final static String TEST_STOPWORDS_RESOURCE_PATH = "/teststopwords.txt";
    private final static String INVALID = "INVALID";
    private final static Set<String> EXPECTED_STOP_WORDS = Set.of("the", "test");

    private StopWordsProvider stopWordsProvider = new StopWordsProviderImpl();

    @Test
    void init_WhenCorrectResourcePathProvided_ShouldReadResourceAndFillStopWords() {
        stopWordsProvider.init(TEST_STOPWORDS_RESOURCE_PATH);

        assertEquals(EXPECTED_STOP_WORDS, stopWordsProvider.getStopWords());
    }

    @Test
    void init_WhenInvalidResourcePathProvided_ShouldThrowExpectedException() {
        String expectedMessage = "Can't read file";
        assertThrows(StopWordsProviderException.class, () -> stopWordsProvider.init(INVALID), expectedMessage);
    }

}
