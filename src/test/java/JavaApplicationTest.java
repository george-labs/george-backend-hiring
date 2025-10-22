import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {
    private static WordCounter wordCounter;

    @BeforeAll
    static void setUp() {
        wordCounter = new WordCounter(List.of("the", "of"));
    }

    @Test
    void shouldCountNullInput() {
        // Given
        String input = null;

        // When
        long wordCount = wordCounter.getWordCount(input);

        // Assert
        assertEquals(0, wordCount);
    }

    @Test
    void shouldCountEmptyString() {
        // Given
        String input = "";

        // When
        long wordCount = wordCounter.getWordCount(input);

        // Assert
        assertEquals(0, wordCount);
    }

    @Test
    void shouldCountSingleWord() {
        // Given
        String input = "word";

        // When
        long wordCount = wordCounter.getWordCount(input);

        // Assert
        assertEquals(1, wordCount);
    }

    @Test
    void shouldCountSentenceWithDelimiters() {
        // Given
        String input = "Word \"word\", (word;word):1 word.";

        // When
        long wordCount = wordCounter.getWordCount(input);

        // Assert
        assertEquals(5, wordCount);
    }

    @Test
    void shouldCountBusinessCaseSentenceWord() {
        // Given
        String input = "Mary had a little lamb";

        // When
        long wordCount = wordCounter.getWordCount(input);

        // Assert
        assertEquals(5, wordCount);
    }

    @Test
    void shouldNotCountStopWords() {
        // Given
        String input = "the word of word";

        // When
        long wordCount = wordCounter.getWordCount(input);

        // Assert
        assertEquals(2, wordCount);
    }

    @Test
    void shouldNotCountMultipleStopWords() {
        // Given
        String input = "the the of of word";

        // When
        long wordCount = wordCounter.getWordCount(input);

        // Assert
        assertEquals(1, wordCount);
    }

    @Test
    void shouldNOTIgnoreCaseInsensitiveStopWords() {
        // Given
        String input = "ThE word OF word";

        // When
        long wordCount = wordCounter.getWordCount(input);

        // Assert
        assertEquals(4, wordCount);
    }
}
