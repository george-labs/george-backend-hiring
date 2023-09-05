package stopwords;

import filereader.FileReaderService;
import filereader.FileReaderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StopWordsReaderImplTest {

    private FileReaderService fileReaderService;

    @BeforeEach
    void setup() {
        fileReaderService = new FileReaderServiceImpl();
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

    StopWordsReader createStopWordsReader(final String stopWordsFileName) {
        final StopWordsReaderConfiguration stopWordsReaderConfiguration =
                new StopWordsReaderConfiguration(stopWordsFileName);

        return new StopWordsReaderImpl(stopWordsReaderConfiguration, fileReaderService);
    }

}
