package unit.input.impl;

import input.impl.FileStopWordsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FileStopWordsProviderTest {

    private FileStopWordsProvider stopWordsProvider;

    @BeforeEach
    void setUp() {
        stopWordsProvider = new FileStopWordsProvider();
    }

    @Test
    void givenStopWordsFileName_whenGetStopWords_thenShouldReturnStopWords() throws NoSuchFileException {
        Set<String> result =  stopWordsProvider.getStopWords("stopwords.txt");

        assertEquals(4, result.size());
        assertTrue(result.contains("the"));
        assertTrue(result.contains("a"));
        assertTrue(result.contains("on"));
        assertTrue(result.contains("off"));
    }

    @Test
    void givenNullFileName_whenGetStopWords_thenShouldThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> stopWordsProvider.getStopWords(null));
    }

    @Test
    void givenEmptyFileName_whenGetStopWords_thenShouldThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> stopWordsProvider.getStopWords(""));
    }

    @Test
    void givenBlankFileName_whenGetStopWords_thenShouldThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> stopWordsProvider.getStopWords("   "));
    }

    @Test
    void givenNonexistingFileNameWhenGetStopWordsThenShouldThrowsIllegalArgumentException() {
        assertThrows(NoSuchFileException.class, () -> stopWordsProvider.getStopWords("invalidName.txt"));
    }

}
