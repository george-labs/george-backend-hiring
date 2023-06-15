import exception.WordCounterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class FileReaderTest {
    public FileReader underTest;

    @Test
    public void testReadWordsFromFileWhenFileExists() {
        underTest = new FileReader("src/test/resources/stopwords.txt");
        List<String> expected = Arrays.asList("Mary", "had");

        Assertions.assertEquals(expected, underTest.readWordsFromFile());
    }


    @Test
    public void testReadWordsFromFileWhenFileDoesNotExist() {
        underTest = new FileReader("src/test/resources/nothing.txt");

        WordCounterException expected = Assertions.assertThrows(WordCounterException.class, () -> {
            underTest.readWordsFromFile();
        });

        Assertions.assertEquals("File could not be found at: src/test/resources/nothing.txt", expected.getMessage());
    }
}