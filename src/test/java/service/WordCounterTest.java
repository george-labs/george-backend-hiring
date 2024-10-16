package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private WordCounter underTest;
    private final Set<String> stopWords = Set.of("a", "the", "on", "off");

    @BeforeEach
    void setUp() {
        underTest = new WordCounter(stopWords);
    }

    @ParameterizedTest
    @CsvSource({
            "'Mary had a little lamb', 4",
            "'Maryhadalittlelamb', 1",
            "'Mary    had   a    little    lamb', 4",
            "'Mary % had a little lamb $%', 4",
            "'Mary had a l&ttle lamb', 3",
            "'Mary had a little lamb 2', 4",
            "'Mary had a little lamb2', 3",
            "'Mary had a li2tle lamb', 3",
            "'Mary had A li2tle lamb', 3",
            "'THE A ON OFF', 0",
            "'the a on off', 0",
            "'', 0"
    })
    public void givenValidString_whenCountWords_thenShouldReturnNumberOfWords(String inputText, int expected) {
        int numberOfWords = underTest.countWords(inputText);
        assertEquals(expected, numberOfWords);
    }

    @Test
    public void givenNullString_whenCountWords_thenShouldReturn0() {
        int numberOfWords = underTest.countWords(null);
        assertEquals(0, numberOfWords);
    }

    @ParameterizedTest
    @CsvSource({
            "'Mary had a little lamb lamb a', 4",
            "'Maryhadalittlelamb', 1",
            "'Mary    had   a    little    lamb', 4",
            "'Mary % had a little lamb $%', 4",
            "'Mary had a l&ttle lamb', 3",
            "'Mary had a little lamb 2', 4",
            "'Mary had a little lamb2', 3",
            "'Mary had a li2tle lamb', 3",
            "'Mary had A li2tle lamb', 3",
            "'THE A ON OFF', 0",
            "'THE A ON OFF off a on', 0",
            "'the a on off', 0",
            "'', 0"
    })
    public void givenValidString_whenCountUniqueWords_thenShouldReturnNumberOfUniqueWords(String inputText, int expected) {
        int numberOfUniqueWords = underTest.uniqueWordCounts(inputText);
        assertEquals(expected, numberOfUniqueWords);
    }

    @Test
    public void givenNullString_whenCountUniqueWords_thenShouldReturn0() {
        int numberOfUniqueWords = underTest.uniqueWordCounts(null);
        assertEquals(0, numberOfUniqueWords);
    }

}
