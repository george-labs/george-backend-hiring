import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordCounterTest {

    @Test
    public void testRegularWords() {
        String text = "Mary had a little lamb";

        int result = new WordCounter(text).countWords(new ArrayList<>());

        assertEquals(5, result);
    }

    @Test
    public void countWordstestingRegularWordsWithStopWords() {
        String text = "Mary had a little lamb";

        int result = new WordCounter(text).countWords(new TextFileStopWords().provideStopWords());

        assertEquals(4, result);
    }

    @Test
    public void countWordstestingWordSplitting() {
        String textWithSpace = "Mary had";
        String textWithSpecialCharacter = "Mary - Sue";

        int resultWithSpace = new WordCounter(textWithSpace).countWords(new ArrayList<>());
        int resultWithSpecialCharacter = new WordCounter(textWithSpecialCharacter).countWords(new ArrayList<>());

        assertEquals(2, resultWithSpace);
        assertEquals(2, resultWithSpecialCharacter);
    }

    @Test
    public void testWordsWithOtherCharacters() {
        String textWithNumbers = "Mary had a little lamb - with 2 heads and 0 eyes.";
        String textNumberOnly = "0000";
        String textNumbersOnly = "0000 1111 2222";

        int resultWithNumbers = new WordCounter(textWithNumbers).countWords(new ArrayList<>());
        int resultWithNumberOnly = new WordCounter(textNumberOnly).countWords(new ArrayList<>());
        int resultWithNumbersOnly = new WordCounter(textNumbersOnly).countWords(new ArrayList<>());

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
