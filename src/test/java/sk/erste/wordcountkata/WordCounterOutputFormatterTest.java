package sk.erste.wordcountkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterOutputFormatterTest {

    @Test
    public void testFormatOutput() {
        WordCounterOutputFormatter wordCounterOutputFormatter = new WordCounterOutputFormatter();
        assertEquals("Number of words: 1, unique: 2; average word length: 3.23 characters",
                wordCounterOutputFormatter.formatOutput(new WordCounter.WordCountStat(1, 2, 3.23422)));
    }

}
