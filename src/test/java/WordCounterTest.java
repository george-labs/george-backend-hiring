import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {
    private WordCounter wordCounter = new WordCounter();
    @BeforeEach


    @Test
    public void testCountWords() {
        int count = wordCounter.countWords("word wor3d");
        assertEquals(3, count);
    }

    @Test
    public void testCountWordsEmpty() {
        int count = wordCounter.countWords("");
        assertEquals(0, count);
    }

    @Test
    public void testCountWordsMoreNumber() {
        int count = wordCounter.countWords("word wor3222d");
        assertEquals(3, count);
    }

    @Test
    public void testCountWordsJustDelimiters() {
        int count = wordCounter.countWords("223");
        assertEquals(0, count);
    }

    @Test
    public void testStopWords() {
        List<String> stopWords = List.of("the", "a", "an", "off");
        String input = "Mary had a little lamb";
        int count = wordCounter.countWords(input, stopWords);
        assertEquals(4, count);
    }

}
