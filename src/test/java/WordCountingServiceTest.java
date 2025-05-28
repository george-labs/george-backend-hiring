import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.WordCountingService;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordCountingServiceTest {

    @Test
    void when_text_contains_words_then_return_number_of_words() {
        String text = "This is a test";
        WordCountingService wordCountingService = new WordCountingService(new MockEmptyStopWordsService());
        var wordCount = wordCountingService.countWords(text);
        assertEquals(4, wordCount);
    }

    @Test
    void when_text_contains_invalid_words_then_return_only_number_of_valid_words() {
        String text = "sdfsd 534 gdgd. 6456 gdf&Y(*";
        WordCountingService wordCountingService = new WordCountingService(new MockEmptyStopWordsService());
        var wordCount = wordCountingService.countWords(text);
        assertEquals(2, wordCount);
    }

    @Test
    void when_there_is_no_text_then_return_zero() {
        String text = "";
        WordCountingService wordCountingService = new WordCountingService(new MockEmptyStopWordsService());
        var wordCount = wordCountingService.countWords(text);
        assertEquals(0, wordCount);

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

        Assertions.assertEquals(3, wordCount);
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


}