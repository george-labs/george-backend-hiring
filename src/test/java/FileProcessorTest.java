import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FileProcessorTest {

    @Test
    void getListOfLinesFromFile_invalidPath() {
        String invalidPath = "invalid.path";
        Assertions.assertThrows(RuntimeException.class, () -> new FileProcessor().getListOfLinesFromFile(invalidPath));
    }


    @Test
    void getListOfLinesFromFile_validPath() {
        List<String> wordsFromFile = new FileProcessor().getListOfLinesFromFile("input.txt");
        List<String> expectedWordsFromFile = Arrays.asList("Mary had","a little", "lamb");
        Assertions.assertArrayEquals(expectedWordsFromFile.toArray(),wordsFromFile.toArray());
    }

}