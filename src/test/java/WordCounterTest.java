import org.junit.jupiter.api.Test;
import util.ResourceUtils;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void test_happy_path() {
        var wordProcessor = new WordCounter("Mary had a little lamb");
        wordProcessor.processString();

        assertEquals(5, wordProcessor.getWordCount());
    }

    @Test
    public void test_non_words() {
        var wordProcessor = new WordCounter("M4ry _had a l1ttle l-a-m-b");
        wordProcessor.processString();

        assertEquals(1, wordProcessor.getWordCount());
    }

    @Test
    public void test_trailing_whitespace() {
        var wordProcessor = new WordCounter("foo bar baz ");
        wordProcessor.processString();

        assertEquals(3, wordProcessor.getWordCount());
    }

    @Test
    public void test_leading_whitespace() {
        var wordProcessor = new WordCounter(" foo bar baz");
        wordProcessor.processString();

        assertEquals(3, wordProcessor.getWordCount());
    }

    @Test
    public void test_sentence_with_comma_and_exclamation() {
        var wordProcessor = new WordCounter("Mary, who had a little lamb said I am hungry!");
        wordProcessor.processString();

        assertEquals(10, wordProcessor.getWordCount());
    }

    @Test
    public void test_sentences_with_question_mark_and_stop() {
        var wordProcessor = new WordCounter("What about Joseph? He was not hungry at all.");
        wordProcessor.processString();

        assertEquals(9, wordProcessor.getWordCount());
    }

    @Test
    public void test_sentence_with_more_than_one_punctuation_mark() {
        var wordProcessor = new WordCounter("Joseph did not have any lambs...");
        wordProcessor.processString();

        assertEquals(5, wordProcessor.getWordCount());
    }

    @Test
    public void test_separate_punctuation_marks_do_not_count_as_words() {
        var wordProcessor = new WordCounter(", . ? !");
        wordProcessor.processString();

        assertEquals(0, wordProcessor.getWordCount());
    }

    @Test
    public void test_stop_words() throws IOException {
        ResourceUtils.populateStopWords(List.of("the", "a", "on", "off"));

        var stopWords = StopWordsLoader.loadStopWords();
        var wordProcessor = new WordCounter("the cat is on and off a table", stopWords);

        wordProcessor.processString();

        assertEquals(4, wordProcessor.getWordCount());
    }

    @Test
    public void test_stop_word_empty_string() throws IOException {
        ResourceUtils.populateStopWords(List.of(" "));

        var stopWords = StopWordsLoader.loadStopWords();
        var wordProcessor = new WordCounter("a cat and a dog", stopWords);

        wordProcessor.processString();

        assertEquals(5, wordProcessor.getWordCount());
    }

    @Test
    public void test_stop_word_with_exclamation_mark() throws IOException {
        ResourceUtils.populateStopWords(List.of("world!"));

        var stopWords = StopWordsLoader.loadStopWords();
        var wordProcessor = new WordCounter("Hello world!", stopWords);

        wordProcessor.processString();

        assertEquals(1, wordProcessor.getWordCount());
    }

}
