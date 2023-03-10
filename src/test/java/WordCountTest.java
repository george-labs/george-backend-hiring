import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCountTest {

    @Test
    void when_input_is_empty_return_0() {
        WordCount wordCount = new WordCount();
        WordCountResult result = wordCount.count("");
        Assertions.assertEquals(0, result.getNumberOfWords());
    }

    @Test
    void when_input_is_one_word_then_return_1() {
        WordCount wordCount = new WordCount();
        WordCountResult result =  wordCount.count("Mary");
        Assertions.assertEquals(1, result.getNumberOfWords());
    }

    @Test
    void when_input_is_sentence_then_return_number_of_words() {
        WordCount wordCount = new WordCount();
        WordCountResult result =  wordCount.count("Mary had a little lamb");
        Assertions.assertEquals(5, result.getNumberOfWords());
    }

    @Test
    void when_input_with_more_than_one_space_then_return_correct_number_of_words() {
        WordCount wordCount = new WordCount();
        WordCountResult result =  wordCount.count("Mary  had a little lamb");
        Assertions.assertEquals(5, result.getNumberOfWords());
    }

    @Test
    void when_input_with_more_a_tab_then_return_correct_number_of_words() {
        WordCount wordCount = new WordCount();
        WordCountResult result =  wordCount.count("Mary\thad a little lamb");
        Assertions.assertEquals(5, result.getNumberOfWords());
    }

    @Test
    void when_input_is_a_number_then_return_0() {
        WordCount wordCount = new WordCount();
        WordCountResult result =  wordCount.count("123");
        Assertions.assertEquals(0, result.getNumberOfWords());
    }

    @Test
    void when_input_contains_number_then_return_correct_number_of_words() {
        WordCount wordCount = new WordCount();
        WordCountResult result =  wordCount.count("Mary had 1 little lamb");
        Assertions.assertEquals(4, result.getNumberOfWords());
    }

    @Test
    void when_input_contains_symbol_then_return_correct_number_of_words() {
        WordCount wordCount = new WordCount();
        WordCountResult result =  wordCount.count("Mary ha@d a & little lamb!");
        Assertions.assertEquals(3, result.getNumberOfWords());
    }

    @Test
    void when_input_only_space_then_return_0() {
        WordCount wordCount = new WordCount();
        WordCountResult result =  wordCount.count(" ");
        Assertions.assertEquals(0, result.getNumberOfWords());
    }

    @Test
    void when_input_contains_punctuation_then_return_correct_number_of_words() {
        WordCount wordCount = new WordCount();
        WordCountResult result =  wordCount.count("Mary had a little lamb.");
        Assertions.assertEquals(4, result.getNumberOfWords());
    }

    @Test
    void when_input_return_number_of_words_and_unique_words() {
        WordCount wordCount = new WordCount();
        String text = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        WordCountResult actualResult = wordCount.count(text);
        Assertions.assertEquals(6, actualResult.getNumberOfWords());
        Assertions.assertEquals(5, actualResult.getNumberOfUniqueWords());
    }

    @Test
    void when_input_is_empty_number_of_words_and_unique_words_0() {
        WordCount wordCount = new WordCount();
        String text = "";
        WordCountResult result = wordCount.count(text);
        Assertions.assertEquals(0, result.getNumberOfWords());
        Assertions.assertEquals(0, result.getNumberOfUniqueWords());
    }

    @Test
    void when_input_is_same_word_uppercase_and_lowercase_return_2() {
        WordCount wordCount = new WordCount();
        String text = "mary MARY";
        WordCountResult result = wordCount.count(text);
        Assertions.assertEquals(2, result.getNumberOfWords());
        Assertions.assertEquals(2, result.getNumberOfUniqueWords());
    }
}
