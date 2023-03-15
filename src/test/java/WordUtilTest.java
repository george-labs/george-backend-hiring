import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordUtilTest {

    private final static String INPUT_TEXT_ALL_VALID = "Mary had a little lamb";
    private final static String INPUT_TEXT_ALL_VALID_No_STOP_WORDS = "Mary had little lamb";
    private final static String INPUT_TEXT_NOT_ALL_VALID = "Mary had a little lamb !";

    @Test
    void shouldGetWordsCountWhenThereStopWords(){
        long wordsCount = WordUtil.getWordsCount(INPUT_TEXT_ALL_VALID);

        assertEquals(4, wordsCount);
    }

    @Test
    void shouldGetWordsCountAndExcludeNotvalidCharWhenThereStopWords(){
        long wordsCount = WordUtil.getWordsCount(INPUT_TEXT_NOT_ALL_VALID);

        assertEquals(4, wordsCount);
    }

    @Test
    void shouldGetFullWordsCountWhenNoStopWords() {
        long wordsCount = WordUtil.getWordsCount(INPUT_TEXT_ALL_VALID_No_STOP_WORDS);

        assertEquals(4, wordsCount);
    }

}