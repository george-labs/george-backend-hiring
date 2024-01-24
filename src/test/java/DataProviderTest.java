import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import providers.FileInputDataProvider;
import providers.IDataProvider;
import utils.Constants;

import java.io.IOException;

class DataProviderTest {
    private IDataProvider inputDataProvider;

    @BeforeEach
    void init() {
        inputDataProvider = new FileInputDataProvider(Constants.STOP_WORDS_LIST_FILE);
    }

    @Test
    void checkFileReader() throws IOException {
        Assertions.assertNotNull(inputDataProvider.getData());
    }

    @Test
    void getStopWords() throws IOException {
        String[] stopWords = inputDataProvider.getData().split(Constants.REGEX);
        Assertions.assertEquals(4, stopWords.length);

    }
}
