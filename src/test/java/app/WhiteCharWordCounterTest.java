package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WhiteCharWordCounterTest {

    private final WhiteCharWordCounter whiteCharWordCounter = new WhiteCharWordCounter();

    @Test
    void Should_count_words_separated_by_whitecharacters() {
        assertEquals(2, whiteCharWordCounter.countWords("   hello hello     "));
        assertEquals(3, whiteCharWordCounter.countWords("hello hello  \uD83D\uDE12   g"));
        assertEquals(2, whiteCharWordCounter.countWords("hello wer2ty  wörd   g"));
    }

}
