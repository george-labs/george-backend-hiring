import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordCounterTest {

    @Test
    public void testRegularWords() {
        String text = "Mary had a little lamb";

        int result = new WordCounter(text).countWords();

        assertEquals(5, result);
    }

    @Test
    public void testWordSplitting() {
        String textWithSpace = "Mary had";
        String textWithSpecialCharacter = "Mary - Sue";

        int resultWithSpace = new WordCounter(textWithSpace).countWords();
        int resultWithSpecialCharacter = new WordCounter(textWithSpecialCharacter).countWords();

        assertEquals(2, resultWithSpace);
        assertEquals(2, resultWithSpecialCharacter);
    }

    @Test
    public void testWordsWithOtherCharacters() {
        String textWithNumbers = "Mary had a little lamb - with 2 heads and 0 eyes.";
        String textNumberOnly = "0000";
        String textNumbersOnly = "0000 1111 2222";

        int resultWithNumbers = new WordCounter(textWithNumbers).countWords();
        int resultWithNumberOnly = new WordCounter(textNumberOnly).countWords();
        int resultWithNumbersOnly = new WordCounter(textNumbersOnly).countWords();

        assertEquals(8, resultWithNumbers);
        assertEquals(0, resultWithNumberOnly);
        assertEquals(0, resultWithNumbersOnly);
    }

    @Test
    void testNullInput() {
        NullPointerException nullPointerException = assertThrows(
                NullPointerException.class,
                () -> new WordCounter(null)
        );
    }
}
