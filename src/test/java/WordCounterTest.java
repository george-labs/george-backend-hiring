import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void test_happy_path() {
        var wordProcessor = new WordCounter(Arrays.asList("Mary had a little lamb", "Its fleece was white as snow"));
        wordProcessor.countWords();

        assertEquals(5 + 6, wordProcessor.getWordCount());
    }

    @Test
    public void test_non_words() {
        var wordProcessor = new WordCounter(Collections.singletonList("M4ry _had a l1ttle l-a-m-b"));
        wordProcessor.countWords();

        assertEquals(1, wordProcessor.getWordCount());
    }

    @Test
    public void test_input_with_whitespace_line() {
        var wordProcessor = new WordCounter(Arrays.asList("hello", "  ", "world!"));
        wordProcessor.countWords();

        assertEquals(2, wordProcessor.getWordCount());
    }

    @Test
    public void test_trailing_whitespace() {
        var wordProcessor = new WordCounter(Collections.singletonList("foo bar baz "));
        wordProcessor.countWords();

        assertEquals(3, wordProcessor.getWordCount());
    }

    @Test
    public void test_leading_whitespace() {
        var wordProcessor = new WordCounter(Collections.singletonList(" foo bar baz"));
        wordProcessor.countWords();

        assertEquals(3, wordProcessor.getWordCount());
    }

    @Test
    public void test_sentence_with_comma_and_exclamation() {
        var wordProcessor = new WordCounter(Collections.singletonList("Mary, who had a little lamb said I am hungry!"));
        wordProcessor.countWords();

        assertEquals(10, wordProcessor.getWordCount());
    }

    @Test
    public void test_sentences_with_question_mark_and_stop() {
        var wordProcessor = new WordCounter(Collections.singletonList("What about Joseph? He was not hungry at all."));
        wordProcessor.countWords();

        assertEquals(9, wordProcessor.getWordCount());
    }

    @Test
    public void test_sentence_with_more_than_one_punctuation_mark() {
        var wordProcessor = new WordCounter(Collections.singletonList("Joseph did not have any lambs..."));
        wordProcessor.countWords();

        assertEquals(5, wordProcessor.getWordCount());
    }

    @Test
    public void test_separate_punctuation_marks_do_not_count_as_words() {
        var wordProcessor = new WordCounter(Collections.singletonList(", . ? !"));
        wordProcessor.countWords();

        assertEquals(0, wordProcessor.getWordCount());
    }

    @Test
    public void test_stop_words() throws IOException {
        var stopWords = List.of("the", "a", "on", "off");
        var wordProcessor = new WordCounter(Collections.singletonList("the cat is on and off a table"), stopWords);

        wordProcessor.countWords();

        assertEquals(4, wordProcessor.getWordCount());
    }

    @Test
    public void test_stop_word_empty_string() throws IOException {
        var stopWords = List.of(" ");
        var wordProcessor = new WordCounter(Collections.singletonList("a cat and a dog"), stopWords);

        wordProcessor.countWords();

        assertEquals(5, wordProcessor.getWordCount());
    }

    @Test
    public void test_stop_word_with_exclamation_mark() throws IOException {
        var stopWords = List.of("world!");
        var wordProcessor = new WordCounter(Collections.singletonList("Hello world!"), stopWords);

        wordProcessor.countWords();

        assertEquals(1, wordProcessor.getWordCount());
    }

}
