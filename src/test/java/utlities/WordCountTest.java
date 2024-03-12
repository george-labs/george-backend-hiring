package utlities;

import org.junit.jupiter.api.Test;
import utilities.WordCounter;

import static org.junit.jupiter.api.Assertions.*;


public class WordCountTest {

    @Test
    public void testCountWordsWithAllValidWords(){

        String input = "Mary had a little lamb";

        int countedWords = WordCounter.countWords(input);

        assertEquals(5, countedWords);
    }

    @Test
    public void testCountWordsWithTrailingSpacesAndInvalidWords(){

        String input = "    Mary h3d a little   lamb   ";

        int countedWords = WordCounter.countWords(input);

        assertEquals(4, countedWords);
    }

    @Test
    public void testCountWordsWithNullInput(){

        String input = null;

        int countedWords = WordCounter.countWords(input);

        assertEquals(0, countedWords);
    }

    @Test
    public void testIsValidWordForValidWord(){

        String input = "Mary";

        boolean isValidWord = WordCounter.isValidWord(input);

        assertTrue(isValidWord);
    }

    @Test
    public void testIsValidWordForInvalidWordWithNumbers(){

        String input = "H3llo";

        boolean isValidWord = WordCounter.isValidWord(input);

        assertFalse(isValidWord);
    }

    @Test
    public void testIsValidWordForInvalidWordWithSpecialCharacters(){

        String input = "H ll$o";

        boolean isValidWord = WordCounter.isValidWord(input);

        assertFalse(isValidWord);
    }

}
