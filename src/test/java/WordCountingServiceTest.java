import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCountingServiceTest {

    @Test
    void when_text_contains_words_then_return_number_of_words() {
        String text = "This is a test";
        WordCountingService wordCountingService = new WordCountingService();
        var wordCount = wordCountingService.countWords(text);
        assertEquals(4, wordCount);
    }

    @Test
    void when_text_contains_invalid_words_then_return_only_number_of_valid_words() {
        String text = "sdfsd 534 gdgd 6456 gdf&Y(*";
        WordCountingService wordCountingService = new WordCountingService();
        var wordCount = wordCountingService.countWords(text);
        assertEquals(2, wordCount);
    }

    @Test
    void when_there_is_no_text_then_return_zero() {
        String text = "";
        WordCountingService wordCountingService = new WordCountingService();
        var wordCount = wordCountingService.countWords(text);
        assertEquals(0, wordCount);

    }

    @Test
    void when_text_is_null_then_throw_exception() {
        String text = null;
        WordCountingService wordCountingService = new WordCountingService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> wordCountingService.countWords(text));
    }
}