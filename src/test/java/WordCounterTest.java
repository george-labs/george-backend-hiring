import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordCounterTest {

    private List<String> words;

    @BeforeEach
    void setUp() {
        List<String> words = new ArrayList<>();
        words.add("Mary");
        words.add("had");
        words.add("little");
        words.add("a");
        words.add("lamb");
    }


    @Test
    public void testRegularWords() {
        int result = new WordCounter(words).countWords(new ArrayList<>());

        assertEquals(5, result);
    }

    @Test
    public void countWordstestingRegularWordsWithStopWords() {
        int result = new WordCounter(words).countWords(new TextFileStopWords().provideStopWords());

        assertEquals(4, result);
    }

    @Test
    public void testWordsWithOtherCharacters() {
        List<String> wordsWithNumbers = new ArrayList<>(words);
        wordsWithNumbers.add("-");
        wordsWithNumbers.add("2");
        wordsWithNumbers.add("heads");
        wordsWithNumbers.add("and");
        wordsWithNumbers.add("0");
        wordsWithNumbers.add("eyes.");

        List<String> wordsNumberOnly = new ArrayList<>();
        wordsNumberOnly.add("0000");

        List<String> wordsNumbersOnly = new ArrayList<>();
        wordsNumberOnly.add("0000");
        wordsNumberOnly.add("1111");
        wordsNumberOnly.add("2222");

        int resultWithNumbers = new WordCounter(wordsWithNumbers).countWords(new ArrayList<>());
        int resultWithNumberOnly = new WordCounter(wordsNumberOnly).countWords(new ArrayList<>());
        int resultWithNumbersOnly = new WordCounter(wordsNumbersOnly).countWords(new ArrayList<>());

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
