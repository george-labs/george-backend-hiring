import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private final WordCounter wordCounter = new WordCounter();

    @DisplayName("Given a text it returns the number of words")
    @Test
    public void wordCount(){
        String text = "Mary had a little lamb";
        String result = wordCounter.countWords(text);
        assertEquals(result, "Number of words: 5");
    }

    @DisplayName("Given a text with numbers or wrong characters the words should not be counted")
    @Test
    public void wordCountWithNumbers(){
        String text = "Mary2 had a little l7";
        String result = wordCounter.countWords(text);
        assertEquals(result, "Number of words: 3");
    }
}
