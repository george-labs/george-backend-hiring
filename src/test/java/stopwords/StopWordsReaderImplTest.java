package stopwords;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StopWordsReaderImplTest {

    @Test
    void should_throw_exception_if_not_found() {
        // prepare data
        final StopWordsReader stopWordsReader = createStopWordsReader("some-nonsense.txt");
        final String expectedErrorMessage = "File 'some-nonsense.txt' not found";

        Exception exception = assertThrows(StopWordsException.class, () -> {
            stopWordsReader.getStopWordsList();
        });

        final String actualExceptionMessage = exception.getMessage();

        assertEquals(expectedErrorMessage, actualExceptionMessage);
    }

    @Test
    void should_read_file_from_resources() {
        // prepare data
        final List<String> expectedStopWords = List.of("aa", "bb");
        final StopWordsReader stopWordsReader = createStopWordsReader("stopwords.txt");

        // call the actual black list reader
        final Collection<String> actualStopWords = stopWordsReader.getStopWordsList();

        // assert the black list values
        System.out.println("");
    }

    static StopWordsReader createStopWordsReader(final String stopWordsFileName) {
        final StopWordsReaderConfiguration stopWordsReaderConfiguration =
                new StopWordsReaderConfiguration(stopWordsFileName);

        return new StopWordsReaderImpl(stopWordsReaderConfiguration);
    }

}
