import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordProcessorTest {

    @Test
    void getStopWordsFromFile_invalidPath_failure() {
        String invalidPath = "invalid.path";
        Assertions.assertThrows(RuntimeException.class, () -> new WordProcessor().getStopWordsFromFile(invalidPath));
    }

    @Test
    void getStopWordsFromFile_validPath_success() {
        List<String> stopWords = new WordProcessor().getStopWordsFromFile(Constants.RESOURCE_PATH+Constants.STOP_WORD_INPUT_SOURCE);
        List<String> expectedStopWords = Arrays.asList("the", "a","on","off");
        Assertions.assertArrayEquals(stopWords.toArray(),expectedStopWords.toArray());
    }

    @Test
    void countWords() {
        List<String> input = Arrays.asList("merry lamb the","2 2 3 4", "  d on a 34= *ff", "  ");
        int[] expectedOutput = {2, 0, 1,0};

        for (String in: input) {
            int wordsCnt = new WordProcessor().countWords(in, Constants.ACCEPTED_CHARS, Constants.STOP_WORD_INPUT_SOURCE);
            Assertions.assertEquals(wordsCnt , expectedOutput[input.indexOf(in)]);
        }

    }
}