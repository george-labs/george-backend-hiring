import exception.WordCounterException;
import org.junit.jupiter.api.Test;
import util.FileReader;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class FileReaderTest {
    public FileReader underTest = new FileReader();

    @Test
    public void testReadWordsFromFileWhenFileExists() {
        List<String> expected = Arrays.asList("Mary", "had");

        assertEquals(expected, underTest.readWordsFromFile("src/test/resources/stopwords.txt"));
    }

    @Test
    public void testReadWordsFromFileWhenFileDoesNotExist() {
        WordCounterException expected = assertThrows(WordCounterException.class, () ->
                underTest.readWordsFromFile("src/test/resources/nothing.txt"));

        assertEquals("File could not be found at: src/test/resources/nothing.txt", expected.getMessage());
    }

    @Test
    public void testReadWordsFromFileAsString() {
        String expected = "Mary had a little lamb";

        assertEquals(expected, underTest.readWordsFromFileAsString("src/test/resources/text.txt"));
    }

    @Test
    public void testReadWordsFromFileAsStringWhenFileDoesNotExist() {
        WordCounterException exception = assertThrows(WordCounterException.class, () ->
                underTest.readWordsFromFileAsString("src/test/resources/nothing.txt"));

        assertEquals(exception.getMessage(), "File could not be found at: src/test/resources/nothing.txt");
    }
}