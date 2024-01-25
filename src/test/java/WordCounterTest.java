import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    public void testCountWords(){
        String test = "Mary had a lamb";
        long expectedCount = 4;
        assertEquals(expectedCount, WordCounter.countWords(test));
    }

    @Test
    public void testCountWordsWithNumericChars(){
        String test = "Mary had 3 lamb";
        long expectedCount = 3;
        assertEquals(expectedCount, WordCounter.countWords(test));
    }
    @Test
    public void testCountWordsWithNumericChars_2(){
        String test = "Mary had 3wr lamb";
        long expectedCount = 3;
        assertEquals(expectedCount, WordCounter.countWords(test));
    }

    @Test
    public void testCountWordsWithOnlyLowercase(){
        String test = "mary had 3 lamb";
        long expectedCount = 3;
        assertEquals(expectedCount, WordCounter.countWords(test));
    }
    @Test
    public void testCountWordsWithOnlyUppercase(){
        String test = "MARY HAD 3 LAMB";
        long expectedCount = 3;
        assertEquals(expectedCount, WordCounter.countWords(test));
    }

    @Test
    public void testCountWordsWithSpecialChars(){
        String test = "Mary had a ^lamb^";
        long expectedCount = 3;
        assertEquals(expectedCount, WordCounter.countWords(test));
    }

    @Test
    public void testCountWordsWithNull(){
        String test = null;
        long expectedCount = 0;
        assertEquals(expectedCount, WordCounter.countWords(test));
    }

    @Test
    public void testCountWordsWithEmpty(){
        String test = "";
        long expectedCount = 0;
        assertEquals(expectedCount, WordCounter.countWords(test));
    }
}