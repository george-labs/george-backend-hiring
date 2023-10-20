import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private final WordCounter wordCounter = new WordCounter();

    @DisplayName("Given a text it returns the number of words")
    @Test
    public void wordCount(){
        String text = "Mary had two little lambs";
        long result = wordCounter.countWords(text);
        assertEquals(result, 5);
    }

    @DisplayName("Given a text with numbers or wrong characters the words should not be counted")
    @Test
    public void wordCountWithNumbers(){
        String text = "Mary2 had a little l7";
        long result = wordCounter.countWords(text);
        assertEquals(result, 2);
    }

    @DisplayName("Given a text with special characters the words should not be counted")
    @Test
    public void wordCountWithSpecialCharacter(){
        String text = "Mary2 had, a little l7";
        long result = wordCounter.countWords(text);
        assertEquals(result, 1);
    }

    @DisplayName("Given a text with a stop word then the stop word should not be counted ")
    @Test
    public void wordCountWithStopWords(){
        String text = "Mary had a little lamb";
        long result = wordCounter.countWords(text);
        assertEquals(result, 4);
    }
}
