import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextUtilTest {

    @Test
    void trimAndSplitWordWithSentenceReturnsSplitWords() {
        String input = "Mary had a little lamb";

        String[] result = TextUtil.trimAndSplitWord(input);
        String[] expected = new String[]{"mary", "had", "a", "little", "lamb"};

        assertArrayEquals(expected, result);
    }

    @Test
    void getTrimmedAndSplitedWordsWithSentenceReturnsSplitWords() {
        String input = "Mary had a little lamb";

        List<String> result = TextUtil.getTrimmedAndSplitedWords(input);
        List<String> expected =  List.of("mary", "had", "a", "little", "lamb");

        assertEquals(expected, result);
    }

    @Test
    void getTrimmedAndSplitedWordsWithNullReturnsEmptyArray() {
        List<String> result = TextUtil.getTrimmedAndSplitedWords(null);
        assertTrue(result.isEmpty());
    }

    @Test
    void trimAndSplitWordWithEmptyStringReturnsSplitWords() {

        List<String> result = TextUtil.getTrimmedAndSplitedWords("");
        assertTrue(result.isEmpty());
    }
}
