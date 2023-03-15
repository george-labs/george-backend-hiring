import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordUtilTest {

    private final static String INPUT_TEXT_ALL_VALID = "Mary had a little lamb";
    private final static String INPUT_TEXT_NOT_ALL_VALID = "Mary had a little lamb !";

    @Test
    void shouldGetWordsCount(){
        long wordsCount = WordUtil.getWordsCount(INPUT_TEXT_ALL_VALID);

        assertEquals(5, wordsCount);
    }

    @Test
    void shouldGetWordsCountAndExcludeNotvalidChar(){
        long wordsCount = WordUtil.getWordsCount(INPUT_TEXT_NOT_ALL_VALID);

        assertEquals(5, wordsCount);
    }

}