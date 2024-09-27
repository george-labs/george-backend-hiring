package george.coding.challenge.job.provider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static george.coding.challenge.Consts.EXCLUDED_WORDS_FILENAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DataProviderTest {
    private DataProvider dataProvider;

    @BeforeEach
    public void setUp() throws IOException {
        dataProvider = new DataProvider(EXCLUDED_WORDS_FILENAME);
    }

    @Test
    public void shouldReadAllFiles() {
        assertEquals(4, dataProvider.getExcludedWords().size());
    }

    @Test
    public void shouldThrowNotFoundExceptionOnceFileIsNotFound() {
        assertThrows(FileNotFoundException.class, () -> new DataProvider("invalid_file.txt"));
    }

}