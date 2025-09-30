package processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {

    private final String ALL_VALID_WORDS_STR = "Mary had a little lamb";
    private final String ONE_OF_THE_WORDS_WITH_NUM_STR = "Mary1 1had a l1ittle lamb";
    private final String ONE_OF_THE_WORDS_WITH_SPECIAL_CHAR_STR = "Mary# #had a l#ittle lamb";

    private final TextProcessor processor = new TextProcessorImpl();

    @Test
    void countWords_whenAllValidWords_ShouldReturnNumberOfWords() {
        long actual = processor.countWords(ALL_VALID_WORDS_STR);

        assertEquals(5, actual);
    }

    @Test
    void countWords_whenWordWithNumber_ShouldReturnNumberOfWordsWithoutInvalidWord() {
        long actual = processor.countWords(ONE_OF_THE_WORDS_WITH_NUM_STR);

        assertEquals(2, actual);
    }

    @Test
    void countWords_whenWordWithSpecialChar_ShouldReturnNumberOfWordsWithoutInvalidWord() {
        long actual = processor.countWords(ONE_OF_THE_WORDS_WITH_SPECIAL_CHAR_STR);

        assertEquals(2, actual);
    }

    @Test
    void countWords_whenEmptyStringSent_ShouldReturnZero() {
        long actual = processor.countWords("");

        assertEquals(0, actual);
    }

}