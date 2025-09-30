package processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextProcessorImplTest {

    private final String ALL_VALID_WORDS_STR = "Mary had a little lamb";
    private final String ONE_OF_THE_WORDS_WITH_NUM_STR = "Mary5 had a little lamb";
    private final String ONE_OF_THE_WORDS_WITH_SPECIAL_CHAR_STR = "Mary# had a little lamb";

    private final TextProcessor processor = new TextProcessorImpl();

    @Test
    void countWords_whenAllValidWords_ShouldReturnNumberOfWords() {
        long actual = processor.countWords(ALL_VALID_WORDS_STR);

        assertEquals(5, actual);
    }

    @Test
    void countWords_whenWordWithNumber_ShouldReturnNumberOfWordsWithoutInvalidWord() {
        long actual = processor.countWords(ONE_OF_THE_WORDS_WITH_NUM_STR);

        assertEquals(4, actual);
    }

    @Test
    void countWords_whenWordWithSpecialChar_ShouldReturnNumberOfWordsWithoutInvalidWord() {
        long actual = processor.countWords(ONE_OF_THE_WORDS_WITH_NUM_STR);

        assertEquals(4, actual);
    }

}