package stopwords;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StopWordsReaderImplTest {

    @Test
    void should_throw_exception_if_not_found() {
        // prepare data
        final StopWordsReader stopWordsReader = createStopWordsReader("some-nonsense.txt");
        final String expectedErrorMessage = "File 'some-nonsense.txt' not found";

        // call the actual getStopWordsList method
        final Exception exception = assertThrows(StopWordsException.class, stopWordsReader::getStopWordsList);

        // assert exception message
        final String actualExceptionMessage = exception.getMessage();

        assertEquals(expectedErrorMessage, actualExceptionMessage);
    }

    @Test
    void should_read_file_from_resources() {
        // prepare data
        final List<String> expectedStopWords = List.of("word1", "word2", "word3");
        final StopWordsReader stopWordsReader = createStopWordsReader("stopwords.txt");

        // call the actual black list reader
        final Set<String> actualStopWords = stopWordsReader.getStopWordsList();

        // assert the black list values
        assertTrue(expectedStopWords.containsAll(actualStopWords));
    }

    static StopWordsReader createStopWordsReader(final String stopWordsFileName) {
        final StopWordsReaderConfiguration stopWordsReaderConfiguration =
                new StopWordsReaderConfiguration(stopWordsFileName);

        return new StopWordsReaderImpl(stopWordsReaderConfiguration);
    }

}
