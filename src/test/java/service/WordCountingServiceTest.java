package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordCountingServiceTest {

    @Test
    void when_text_contains_words_then_return_number_of_words() {
        String text = "This is a test";
        WordCountingService wordCountingService = new WordCountingService(new MockEmptyStopWordsService());
        var wordCount = wordCountingService.countWords(text);
        assertEquals(4, wordCount.wordCount());
    }

    @Test
    void when_text_contains_invalid_words_then_return_only_number_of_valid_words() {
        String text = "sdfsd 534 gdgd. 6456 gdf&Y(*";
        WordCountingService wordCountingService = new WordCountingService(new MockEmptyStopWordsService());
        var wordCount = wordCountingService.countWords(text);
        assertEquals(2, wordCount.wordCount());
    }

    @Test
    void when_there_is_no_text_then_return_zero() {
        String text = "";
        WordCountingService wordCountingService = new WordCountingService(new MockEmptyStopWordsService());
        var wordCount = wordCountingService.countWords(text);
        assertEquals(0, wordCount.wordCount());

    }

    @Test
    void when_text_is_null_then_throw_exception() {
        String text = null;
        WordCountingService wordCountingService = new WordCountingService(new MockEmptyStopWordsService());
        Assertions.assertThrows(IllegalArgumentException.class, () -> wordCountingService.countWords(text));
    }


    @Test
    void when_stop_words_are_in_text_then_do_not_count_them() {
        String text = "This is a test";
        Set<String> stopWords = Collections.singleton("this");

        WordCountingService wordCountingService = new WordCountingService(new MockStopWordsService());
        var wordCount = wordCountingService.countWords(text);

        Assertions.assertEquals(3, wordCount.wordCount());
    }

    @Test
    void when_stop_words_are_empty_then_no_exception_is_thrown() {
        String text = "This is a test";
        Set<String> stopWords = Collections.emptySet();

        WordCountingService wordCountingService = new WordCountingService(new MockEmptyStopWordsService());
        Assertions.assertDoesNotThrow(() -> wordCountingService.countWords(text));
    }

    @Test
    void when_stop_words_are_null_then_exception_is_thrown() {
        String text = "This is a test";

        WordCountingService wordCountingService = new WordCountingService(new MockNullStopWordsService());

        Assertions.assertThrows(IllegalArgumentException.class, () -> wordCountingService.countWords(text));
    }

    @Test
    void when_counting_words_in_text_with_duplicates_then_the_unique_word_count_is_correct() {
        String text = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

        WordCountingService wordCountingService = new WordCountingService(new MockStopWordsService());

        var countingResult = wordCountingService.countWords(text);

        Assertions.assertEquals(7, countingResult.wordCount());
        Assertions.assertEquals(6, countingResult.uniqueWordCount());
    }

    @Test
    void when_counting_words_then_correct_average_length_is_calculated() {
        String text = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

        WordCountingService wordCountingService = new WordCountingService(new MockStopWordsService());

        var countingResult = wordCountingService.countWords(text);

        Assertions.assertEquals(6.43, countingResult.averageLength(), 0.005);
    }




}