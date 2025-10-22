import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    @Test
    void shouldCountNullInput() {
        // Given
        WordCounter wordCounter = new WordCounter();
        String input = null;

        // When
        long wordCount = wordCounter.getWordCount(input);

        // Assert
        assertEquals(0, wordCount);
    }

    @Test
    void shouldCountEmptyString() {
        // Given
        WordCounter wordCounter = new WordCounter();
        String input = "";

        // When
        long wordCount = wordCounter.getWordCount(input);

        // Assert
        assertEquals(0, wordCount);
    }

    @Test
    void shouldCountSingleWord() {
        // Given
        WordCounter wordCounter = new WordCounter();
        String input = "word";

        // When
        long wordCount = wordCounter.getWordCount(input);

        // Assert
        assertEquals(1, wordCount);
    }

    @Test
    void shouldCountSentenceWithDelimiters() {
        // Given
        WordCounter wordCounter = new WordCounter();
        String input = "Word \"word\", (word;word):1 word.";

        // When
        long wordCount = wordCounter.getWordCount(input);

        // Assert
        assertEquals(5, wordCount);
    }

    @Test
    void shouldCountBCSentenceWord() {
        // Given
        WordCounter wordCounter = new WordCounter();
        String input = "Mary had a little lamb";

        // When
        long wordCount = wordCounter.getWordCount(input);

        // Assert
        assertEquals(5, wordCount);
    }
}
