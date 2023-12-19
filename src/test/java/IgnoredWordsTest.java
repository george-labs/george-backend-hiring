import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class IgnoredWordsTest {

    private IgnoredWords ignoredWords = new IgnoredWords();

    @Test
    void testGetIgnoredWordsWithValidFilename() {
        var expectedOutput = List.of("the", "a", "on", "off");
        var ignoredWordsList = ignoredWords.getIgnoredWords("stopwords.txt");
        Assertions.assertTrue(expectedOutput.containsAll(ignoredWordsList));
        Assertions.assertTrue(ignoredWordsList.containsAll(expectedOutput));
    }

    @Test
    void testGetIgnoredWordsWithInvalidFilename() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ignoredWords.getIgnoredWords("stopwordss.txt"));
    }

}