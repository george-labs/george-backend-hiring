package input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileStopWordsProviderTest {

    private FileWordsProvider underTest;

    @BeforeEach
    public void setUp() {
        underTest = new FileWordsProvider();
    }

    @ParameterizedTest
    @CsvSource({
            "'src/test/resources/correct_stop_words.txt', the;on;off;a",
            "'src/test/resources/duplicated_stop_words.txt', the;on;off;a",
    }
    )
    public void givenValidFile_whenGetStopWords_thenReturnStopWords(String filePath, String expected) throws IOException {
        Set<String> stopWords = new HashSet<>(underTest.getWords(filePath));
        Set<String> words = Arrays.stream(expected.split(";")).collect(Collectors.toSet());
        assertEquals(words, stopWords);
    }

    @Test
    public void givenEmptyFile_whenGetStopWords_thenReturnNoWords() throws IOException {
        Set<String> stopWords = new HashSet<>(underTest.getWords("src/test/resources/empty_stop_words.txt"));
        assertEquals(0, stopWords.size());
    }

}
