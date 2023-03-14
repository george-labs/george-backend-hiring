import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountWordsTest {

    String inputString = "one two three";
    InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
    UserInput userInput = new UserInputImpl(inputStream);
    private final CountWords countWords = new CountWords(userInput);

    private final String TEXT = "Mary had a little lamb";
    private final String TEXT_WITH_NOT_ACCEPTED_LETTERS = "george session 2 -words";

    private List<String> stopwords = Arrays.asList("the", "a", "on", "off");

    @Test
    void wordsCount_success_test() {
        int count = countWords.count(TEXT, stopwords);

        assertEquals(4, count);
    }

    @Test
    void wordsCount_count_only_words_with_given_letters_test() {
        int count = countWords.count(TEXT_WITH_NOT_ACCEPTED_LETTERS, stopwords);

        assertNotEquals(4, count);
        assertEquals(2, count);
    }
}