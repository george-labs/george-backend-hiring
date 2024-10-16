package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private WordCounter underTest;
    private Set<String> stopWords = Set.of("a", "the", "on", "off");

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
        String inputText = null;
        int numberOfWords = underTest.countWords(inputText);
        assertEquals(0, numberOfWords);
    }

}
