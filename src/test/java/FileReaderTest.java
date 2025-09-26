import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileReaderTest {

    private final FileReader fileReader;

    public FileReaderTest() {
        this.fileReader = new FileReader();
    }

    @Test
    void getWordsFromFileWithExistingFileReturnsListOfWords() throws Exception {

        int expectedResult = 4;
        List<String> result = fileReader.getWordsFromFile("stopwords.txt");

        assertEquals(expectedResult, result.size());
    }

    @Test
    void getWordsFromFileWithNonExistingFileThrowsException() {

        assertThrows(Exception.class, () -> fileReader.getWordsFromFile("badFileName.txt"));
    }
}
