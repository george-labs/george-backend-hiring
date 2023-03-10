import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCountTest {

    @Test
    void when_input_is_empty_return_0() {
        WordCount wordCount = new WordCount();
        Long numberWords = wordCount.count("");
        Assertions.assertEquals(numberWords, 0);
    }

    @Test
    void when_input_is_one_word_then_return_1() {
        WordCount wordCount = new WordCount();
        Long numberWords = wordCount.count("Mary");
        Assertions.assertEquals(numberWords, 1);
    }

    @Test
    void when_input_is_sentence_then_return_number_of_words() {
        WordCount wordCount = new WordCount();
        Long numberWords = wordCount.count("Mary had a little lamb");
        Assertions.assertEquals(numberWords, 5);
    }

    @Test
    void when_input_with_more_than_one_space_then_return_correct_number_of_words() {
        WordCount wordCount = new WordCount();
        Long numberWords = wordCount.count("Mary  had a little lamb");
        Assertions.assertEquals(5, numberWords);
    }

    @Test
    void when_input_with_more_a_tab_then_return_correct_number_of_words() {
        WordCount wordCount = new WordCount();
        Long numberWords = wordCount.count("Mary\thad a little lamb");
        Assertions.assertEquals(5, numberWords);
    }
}
