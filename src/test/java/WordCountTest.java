import org.junit.jupiter.api.*;

import java.util.Set;
import java.util.stream.Stream;

public class WordCountTest {
    @TestFactory
    Stream<DynamicTest> dynamicTestsFromCollection() {
        return Stream.of("-mary", "mary-", "---", "-", "Humpty--Dumpty Humpty--Dumpty", "", " ", "123").map(s ->
                DynamicTest.dynamicTest("Test invalid input: " + s, () -> {
                    WordCount wordCount = new WordCount();
                    WordCountResult result = wordCount.count(s);
                    Assertions.assertEquals(0, result.getNumberOfWords());
                    Assertions.assertEquals(0, result.getNumberOfUniqueWords());
        }));
    }
    @Test
    void when_input_is_one_word_then_return_1() {
        assertEquals("Mary", 1, 1, 4, Set.of("Mary"));
    }
    @Test
    void when_input_is_sentence_then_return_number_of_words() {
        assertEquals("Mary had a little lamb", 5, 5, 3.6, Set.of("Mary", "had", "a", "little", "lamb"));
    }
    @Test
    void when_input_with_more_than_one_space_then_return_correct_number_of_words() {
        assertEquals("Mary  had a little lamb", 5, 5, 3.6);
    }
    @Test
    void when_input_with_more_a_tab_then_return_correct_number_of_words() {
        assertEquals("Mary\thad a little lamb", 5, 5);
    }
    @Test
    void when_input_contains_number_then_return_correct_number_of_words() {
        assertEquals("Mary had 1 little lamb", 4, 4);
    }
    @Test
    void when_input_contains_symbol_then_return_correct_number_of_words() {
        assertEquals("Mary ha@d a & little lamb!", 3, 3);
    }
    @Test
    void when_input_contains_punctuation_then_return_correct_number_of_words() {
        assertEquals("Mary had a little lamb.", 4, 4);
    }
    @Test
    void when_input_return_number_of_words_and_unique_words() {
        assertEquals("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 8, 6);
    }
    @Test
    void when_input_is_same_word_uppercase_and_lowercase_return_2() {
        assertEquals("mary MARY", 2, 2);
    }
    @Test
    void when_input_with_hypen_then_return_correct_number_of_words() {
        assertEquals("Humpty-Dumpty", 1, 1);
    }
    @Test
    void when_input_has_hypen_then_return_correct_number_of_words() {
        assertEquals("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 8, 6);
    }
    @Test
    void when_hypen_is_in_a_sentence_then_do_not_count_as_word() {
        assertEquals("Mary - a little lamb.", 3, 3);
    }
    private void assertEquals(String text, int expectedNumberOfWords, int expectedNumberOfUniqueWords ) {
        WordCountResult result = WordCount.count(text);
        Assertions.assertEquals(expectedNumberOfWords, result.getNumberOfWords());
        Assertions.assertEquals(expectedNumberOfUniqueWords, result.getNumberOfUniqueWords());
    }

    private void assertEquals(String text, int expectedNumberOfWords, int expectedNumberOfUniqueWords, double averageWordLength ) {
        WordCountResult result = WordCount.count(text);
        Assertions.assertEquals(expectedNumberOfWords, result.getNumberOfWords());
        Assertions.assertEquals(expectedNumberOfUniqueWords, result.getNumberOfUniqueWords());
        Assertions.assertEquals(averageWordLength, result.getAverageWordLength());
    }

    private void assertEquals(String text, int expectedNumberOfWords, int expectedNumberOfUniqueWords, double averageWordLength, Set<String> expectedIndex ) {
        WordCountResult result = WordCount.count(text);
        Assertions.assertEquals(expectedNumberOfWords, result.getNumberOfWords());
        Assertions.assertEquals(expectedNumberOfUniqueWords, result.getNumberOfUniqueWords());
        Assertions.assertEquals(averageWordLength, result.getAverageWordLength());
        Assertions.assertEquals(expectedIndex, result.getIndex());
    }
}
